package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.IngredientJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.RecipeJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.recipe.RecipeAddDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.recipe.RecipeCreate;
import Mk.JD2_95_22.fitness.core.dto.nutrition.ingredient.IngredientCreate;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.core.exception.product.RecipeAlreadyExistException;
import Mk.JD2_95_22.fitness.core.exception.product.RecipeNotFoundExeption;
import Mk.JD2_95_22.fitness.core.exception.product.RecipeValidateExeption;
import Mk.JD2_95_22.fitness.service.validate.RecipeValidator;
import Mk.JD2_95_22.fitness.orm.entity.IngredientEntity;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import Mk.JD2_95_22.fitness.orm.entity.RecipeEntity;
import Mk.JD2_95_22.fitness.orm.repository.product.IRecipeRepository;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.service.api.product.IRecipeService;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.VersionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
public class RecipeService implements IRecipeService {
    private final IRecipeRepository repository;
    private final IProductService productService;
    private final ConversionService conversionService;
    private final RecipeValidator validator;

    public RecipeService(IRecipeRepository repository, IProductService productService, ConversionService conversionService, RecipeValidator validator) {
        this.repository = repository;
        this.productService = productService;
        this.conversionService = conversionService;
        this.validator = validator;
    }


@Override
@Transactional
public UUID create(@Validated  RecipeCreate recipe) {
    RecipeEntity recipeEntity = repository.findByTitle(recipe.getTitle());
    if (recipeEntity != null) {
        throw new DoubleException("Рецепт с таким названием уже существует");
    } else {
        validator.validate(recipe);
        checkDoubleRecipe(recipe);
        List<IngredientCreate> ingredientDTOList = recipe.getComposition();
        List<IngredientEntity> list = new ArrayList<>();
        for (IngredientCreate s : ingredientDTOList) {
            IngredientEntity ingredientEntity = new IngredientEntity(conversionService.convert(productService.getProduct(s.getProduct()), ProductEntity.class),
                    s.getWeight());
            list.add(ingredientEntity);
        }
        RecipeAddDTO savedRecipeDTO = new RecipeAddDTO(recipe);
        repository.save(new RecipeEntity(savedRecipeDTO.getUuid(), savedRecipeDTO.getDtCreate(),
                savedRecipeDTO.getDtUpdate(), savedRecipeDTO.getAddRecipeDTO().getTitle(),
                list));
        return savedRecipeDTO.getUuid();
    }}

//    validator.validate(recipe);
//    checkDoubleRecipe(recipe);
//    List<IngredientCreate> ingredientDTO = recipe.getComposition();
//    if (!conversionService.canConvert(ProductCreate.class, ProductEntity.class)) {
//        throw new IllegalStateException("Can not convert IngredientDTO.class to IngredientEntity.class");
//    }
//    List<IngredientEntity> collect = ingredientDTO.stream()
//            .map(s -> {
//                ProductJsonModel product = productService.getProduct(s.getProduct());
//                ProductEntity productEntity = conversionService.convert(product, ProductEntity.class);
//                return new IngredientEntity(productEntity, s.getWeight());
//            })
//            .collect(Collectors.toList());
//    UUID uuid = UUID.randomUUID();
//    Instant dt = Instant.now();
//    repository.save(new RecipeEntity(uuid, dt, dt, recipe.getTitle(), collect));
//    return uuid;
//}


//    @Override
//    public PageDTO<RecipeJsonModel> get(int page, int size) {
//        PageRequest paging = PageRequest.of(page, size);
//        Page<RecipeEntity> all = repository.findAll(paging);
//        if (!conversionService.canConvert(RecipeEntity.class, RecipeJsonModel.class)) {
//            throw new IllegalStateException("Can not convert RecipeEntity.class to RecipeModel.class");
//        }
//        List<RecipeJsonModel> recipePages = new ArrayList<>();
//        for (RecipeEntity recipeEntity : all.getContent()) {
//            RecipeJsonModel convert = conversionService.convert(recipeEntity, RecipeJsonModel.class);
//            recipePages.add(convert);
//        }
//        return new PageDTO<RecipeJsonModel>(page,
//                size,
//                all.getTotalPages(),
//                all.getTotalElements(),
//                all.isFirst(),
//                all.getNumberOfElements(),
//                all.isLast(),
//                recipePages);
//    }



    @Override
    public PageDTO<RecipeJsonModel> get(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<RecipeEntity> all = repository.findAll(paging);

        List<RecipeJsonModel> recipePages = new ArrayList<>();
        List<RecipeEntity> content = all.getContent();
        for (RecipeEntity recipeEntity : content) {
            List<IngredientJsonModel> ingredientDTOList = new ArrayList<>();
            for (IngredientEntity ingredient : recipeEntity.getComposition()) {
                IngredientJsonModel ingredientJsonModel = new IngredientJsonModel(
                       productService.getProduct(ingredient.getProduct().getUuid()),
                        ingredient.getWeight(),
                        ingredient.getWeight() * ingredient.getProduct().getCalories() / ingredient.getProduct().getWeight(),
                         (double) ingredient.getProduct().getProteins()* (ingredient.getWeight() / ingredient.getProduct().getWeight()),
                        (double) ingredient.getProduct().getFats()* (ingredient.getWeight() / ingredient.getProduct().getWeight()),
                        (double) ingredient.getProduct().getCarbohydrates()* (ingredient.getWeight() / ingredient.getProduct().getWeight())
                );
                ingredientDTOList.add(ingredientJsonModel);
            }

            int weight=0;
            int calories=0;
            double proteins=0.0;
            double fats=0.0;
            double carbohydrates=0.0;

            for (IngredientJsonModel ingredientJsonModel : ingredientDTOList) {
                weight +=ingredientJsonModel.getWeight();
                calories += ingredientJsonModel.getCalories();
                proteins += ingredientJsonModel.getProteins();
                fats += ingredientJsonModel.getFats();
                carbohydrates += ingredientJsonModel.getCarbohydrates();
            }

//            int sum = 0;
//            for (IngredientJsonModel ingredientJsonModel : ingredientDTOList) {
//                int ingredientJsonModelWeight = ingredientJsonModel.getWeight();
//                sum += ingredientJsonModelWeight;
//            }
//            Integer weight = sum;
//
//            int result = 0;
//            for (IngredientJsonModel ingredientJsonModel : ingredientDTOList) {
//                int ingredientJsonModelCalories = ingredientJsonModel.getCalories();
//                result += ingredientJsonModelCalories;
//            }
//            Integer calories = result;
//
//            double sum1 = 0.0;
//            for (IngredientJsonModel ingredientJsonModel : ingredientDTOList) {
//                double ingredientJsonModelProteins = ingredientJsonModel.getProteins();
//                sum1 += ingredientJsonModelProteins;
//            }
//            Double proteins = sum1;
//
//            double result1 = 0.0;
//            for (IngredientJsonModel ingredientJsonModel : ingredientDTOList) {
//                double ingredientJsonModelFats = ingredientJsonModel.getFats();
//                result1 += ingredientJsonModelFats;
//            }
//            Double fats = result1;
//
//            double sum2 = 0.0;
//            for (IngredientJsonModel ingredientJsonModel : ingredientDTOList) {
//                double ingredientJsonModelCarbohydrates = ingredientJsonModel.getCarbohydrates();
//                sum2 += ingredientJsonModelCarbohydrates;
//            }
//            Double carbohydrates = sum2;

            recipePages.add(new RecipeJsonModel(recipeEntity.getUuid(), recipeEntity.getDtCreate(), recipeEntity.getDtUpdate(), recipeEntity.getTitle(), ingredientDTOList,
                    weight, calories, proteins, fats, carbohydrates));
        }
        return new PageDTO<>(page, size, all.getTotalPages(), all.getTotalElements(), all.isFirst(), all.getNumberOfElements(), all.isLast(), recipePages);
    }



//    public UUID update(RecipeUpdate recipe)  {
//        RecipeEntity recipeEntity = repository.findById(recipe.getUuid()).orElseThrow(() -> new RecipeNotFoundExeption("Такого рецепта не существует"));
//        checkIngredient(recipe.getAddRecipeDTO().getComposition());
//
//        if (!conversionService.canConvert(ProductJsonModel.class, ProductEntity.class)) {
//            throw new IllegalStateException("Can not convert ProductModel.class to ProductEntity.class");
//        }
//
//        if (recipe.getDtUpdate().toEpochMilli() == recipeEntity.getDtUpdate().toEpochMilli()) {
//            List<IngredientCreate> ingredientDTOList = recipe.getAddRecipeDTO().getComposition();
//            List<IngredientEntity> list = new ArrayList<>();
//            for (IngredientCreate s : ingredientDTOList) {
//                IngredientEntity ingredientEntity = new IngredientEntity(conversionService.convert(productService.getProduct(s.getProduct()), ProductEntity.class),
//                        s.getWeight());
//                list.add(ingredientEntity);
//            }
//            recipeEntity.setTitle(recipe.getAddRecipeDTO().getTitle());
//            recipeEntity.setComposition(list);
//            repository.save(recipeEntity);
//        } else throw new VersionException("Такой версии не существует");
//        return recipe.getUuid();
//    }
    @Override
    @Transactional
    public UUID update(UUID id, Instant version, RecipeCreate product) throws RecipeValidateExeption {
        validator.validate(product);
        RecipeEntity recipeEntity =repository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundExeption("There is no recipe with such id"));
        if (version.toEpochMilli() != recipeEntity.getDtUpdate().toEpochMilli()) {
            throw new VersionException("Version is not correct");
        }
        if (!conversionService.canConvert(ProductJsonModel.class, ProductEntity.class)) {
            throw new IllegalStateException("Can not convert ProductModel.class to ProductEntity.class");
        }
        List <IngredientEntity> collect= product.getComposition().stream()
                .map(s -> {
                    ProductJsonModel productModel = productService.getProduct(s.getProduct());
                    ProductEntity productEntity = conversionService.convert(productModel, ProductEntity.class);
                    return new IngredientEntity(productEntity, s.getWeight());
                })
                .collect(Collectors.toList());
        recipeEntity.setTitle(product.getTitle());
        recipeEntity.setComposition(collect);
        repository.save(recipeEntity);
        return id;
    }

    private void checkDoubleRecipe(RecipeCreate recipe) {
        String title = recipe.getTitle();
        if (repository.findByTitle(title) != null) {
            throw new RecipeAlreadyExistException("Product with title '" + title + "' has already existed");
        }
    }

}
