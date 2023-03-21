package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.IngredientJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.RecipeJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.recipe.RecipeAddDTO;
import Mk.JD2_95_22.fitness.core.dto.recipe.RecipeCreate;
import Mk.JD2_95_22.fitness.core.dto.recipe.RecipeUpdate;
import Mk.JD2_95_22.fitness.core.dto.recipe.ingredient.IngredientCreate;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.product.RecipeNotFoundExeption;
import Mk.JD2_95_22.fitness.core.exception.validation.RecipeValidator;
import Mk.JD2_95_22.fitness.orm.entity.IngredientEntity;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import Mk.JD2_95_22.fitness.orm.entity.RecipeEntity;
import Mk.JD2_95_22.fitness.orm.repository.product.IRecipeRepository;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.service.api.product.IRecipeService;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.VersionException;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.DoubleException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void create(RecipeCreate recipeDTO) {
        RecipeEntity recipeEntity = repository.findByTitle(recipeDTO.getTitle());
        if (recipeEntity != null) {
            throw new DoubleException("Recipe with this is a title is exist");
        } else {
            List<IngredientCreate> ingredientDTOList = recipeDTO.getComposition();
            List<IngredientEntity> list = new ArrayList<>();
            for (IngredientCreate s : ingredientDTOList) {
                IngredientEntity ingredientEntity = new IngredientEntity(conversionService
                        .convert(productService.get(s.getProduct()), ProductEntity.class),
                        s.getWeight());
                list.add(ingredientEntity);
            }
            RecipeAddDTO recipeAddDTO = new RecipeAddDTO(recipeDTO);
            repository.save(new RecipeEntity(recipeAddDTO.getDtCreate(),
                    recipeAddDTO.getDtUpdate(), recipeAddDTO.getAddRecipeDTO().getTitle(),
                    list));
        }
    }

    @Override
    public PageDTO<RecipeJsonModel> get(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<RecipeEntity> all = repository.findAll(paging);
        List<RecipeJsonModel> recipePages = new ArrayList<>();
        List<RecipeEntity> content = all.getContent();
        for (RecipeEntity recipeEntity : content) {
            List<IngredientJsonModel> ingredientJsonModelList = recipeEntity.getComposition().stream().
                    map(s -> new IngredientJsonModel(productService.get(
                            s.getProduct().getUuid()),
                            s.getWeight(),
                            s.getWeight() * s.getProduct().getCalories() / s.getProduct().getWeight(),
                            (s.getWeight() * (double) s.getProduct().getCalories() / s.getProduct().getWeight()),
                            (s.getWeight() * (double) s.getProduct().getCalories() / s.getProduct().getWeight()),
                            (s.getWeight() * (double) s.getProduct().getCalories() / s.getProduct().getWeight())
                    )).collect(Collectors.toList());
            Integer weight = ingredientJsonModelList.stream()
                    .mapToInt(IngredientJsonModel::getWeight).sum();

            Integer calories = ingredientJsonModelList.stream()
                    .mapToInt(IngredientJsonModel::getCalories).sum();

            Double proteins = ingredientJsonModelList.stream()
                    .mapToDouble(IngredientJsonModel::getProteins).sum();

            Double fats = ingredientJsonModelList.stream()
                    .mapToDouble(IngredientJsonModel::getFats).sum();

            Double carbohydrates = ingredientJsonModelList.stream()
                    .mapToDouble(IngredientJsonModel::getCarbohydrates).sum();

            recipePages.add(new RecipeJsonModel(recipeEntity.getUuid(),
                    recipeEntity.getDtCreate(),
                    recipeEntity.getDtUpdate(),
                    recipeEntity.getTitle(),
                    ingredientJsonModelList,
                    weight,
                    calories,
                    proteins,
                    fats,
                    carbohydrates));
        }
        return new PageDTO<>(page,
                size,
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                recipePages);
    }
    @Override
    public void update(RecipeUpdate recipeDTO) {
        RecipeEntity recipeEntity = repository.findById(recipeDTO.getUuid()).orElseThrow(() ->
                new RecipeNotFoundExeption("This recipe does not exist"));
        if (recipeDTO.getDtUpdate().toEpochMilli() == recipeEntity.getDtUpdate().toEpochMilli()) {
            List<IngredientCreate> ingredientDTOList = recipeDTO.getAddRecipeDTO().getComposition();
            List<IngredientEntity> list = new ArrayList<>();
            for (IngredientCreate ingredient : ingredientDTOList) {
                IngredientEntity ingredientEntity = new IngredientEntity(conversionService
                        .convert(productService.get(ingredient.getProduct()), ProductEntity.class),
                        ingredient.getWeight());
                list.add(ingredientEntity);
            }
            recipeEntity.setTitle(recipeDTO.getAddRecipeDTO().getTitle());
            recipeEntity.setComposition(list);
            repository.save(recipeEntity);
        } else throw new VersionException("This is version does not exist");
    }
}
