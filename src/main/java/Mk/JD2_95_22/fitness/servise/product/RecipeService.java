package Mk.JD2_95_22.fitness.servise.product;


import Mk.JD2_95_22.fitness.core.dto.model.ProductModel;
import Mk.JD2_95_22.fitness.core.dto.model.RecipeModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.*;
import Mk.JD2_95_22.fitness.core.exeption.SingleErrorResponse;
import Mk.JD2_95_22.fitness.orm.entity.product.IngridientsEntity;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import Mk.JD2_95_22.fitness.orm.entity.product.RecipeEntity;
import Mk.JD2_95_22.fitness.orm.repository.IRecipeRepository;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import Mk.JD2_95_22.fitness.servise.api.product.IRecipeService;
import Mk.JD2_95_22.fitness.servise.my_exeption.product.RecipeNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.product.RecipeValidateExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.version.InvalidVersionExeption;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;
import jakarta.validation.ValidationException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class RecipeService implements IRecipeService {
    private final IRecipeRepository recepteRepository;
    private final IProductService service;
    private final ConversionService conversionService;
    private final IValidator<RecipeCreatedForCU> validator;

    public RecipeService(IRecipeRepository recepteRepository, IProductService service, ConversionService conversionService, IValidator<RecipeCreatedForCU> validator) {
        this.recepteRepository = recepteRepository;
        this.service = service;
        this.conversionService = conversionService;
        this.validator = validator;
    }

    @Override
    public void create( RecipeCreatedForCU recipe) {
        checkDoubleRecipe(recipe);
        validator.validate(recipe);
        List<Ingridients> ingredientDTOList = recipe.getComposition();
        List<IngridientsEntity> list = new ArrayList<>();
        Instant dtCreated=Instant.now();
        Instant dtUpdate=dtCreated;

        for (Ingridients ingridients : ingredientDTOList) {
            UUID uuid= ingridients.getProduct().getUuid();
            ProductEntity productEntity=service.getProducts(uuid);

        list.add(new IngridientsEntity(productEntity, ingridients.getWeight()));
        }

        RecipeEntity recipeEntity=new RecipeEntity(
                UUID.randomUUID(),
                dtCreated,
                dtUpdate,
                recipe.getTitle(),
                list);
        Optional<RecipeEntity> optionalRecipe=recepteRepository.getAllByTitleIgnoreCase(recipe.getTitle());
        if(optionalRecipe.isPresent()){
            if(Objects.equals(recipeEntity.getTitle(),optionalRecipe.get().getTitle()) &&
                    Objects.equals(recipeEntity.getComposition(),optionalRecipe.get().getComposition())){
                throw new SingleErrorResponse("This recipe already exists");
            }
        }
        recepteRepository.save(recipeEntity);
    }


    @Override
    public void add(@Validated RecipeCreatedForCU recipeDTO)  throws RecipeValidateExeption {
        validator.validate(recipeDTO);
        checkDoubleRecipe(recipeDTO);
        List<Ingridients> ingredientDTO = recipeDTO.getComposition();
        if (!conversionService.canConvert(ProductDTO.class, ProductEntity.class)) {
            throw new IllegalStateException("Can not convert IngredientDTO.class to IngredientEntity.class");
        }
        List<IngridientsEntity> collect = ingredientDTO.stream()
                .map(s -> {
                    ProductModel product =  conversionService.convert(service.getProduct(s.getProduct().getUuid()),ProductModel.class);
                    ProductEntity productEntity = conversionService.convert(product, ProductEntity.class);
                    return new IngridientsEntity(productEntity, s.getWeight());
                })
                .collect(Collectors.toList());
        UUID uuid = UUID.randomUUID();
        Instant dtCreated = Instant.now();
        Instant dtUpdate=dtCreated;
        recepteRepository.save(new RecipeEntity(uuid, dtCreated, dtUpdate, recipeDTO.getTitle(), collect));
    }

    public PageDTO<RecipeModel> getPageRecipe(Pageable paging) {
        Page<RecipeEntity> all = recepteRepository.findAll(paging);
        if (!conversionService.canConvert(RecipeEntity.class, RecipeModel.class)) {
            throw new SingleErrorResponse("Can not convert RecipeEntity.class to RecipeModel.class");
        }
        List<RecipeModel> content = new ArrayList<>();
        for (RecipeEntity recipeEntity : all.getContent()) {
            RecipeModel convert = conversionService.convert(recipeEntity, RecipeModel.class);
            if(convert==null){
        throw new SingleErrorResponse("Page not found");
            }
            return PageDTO.PagesBuilder.<RecipeModel>create()
                    .setNumber(all.getNumber()).setContent(content)
                    .setFirst(all.isFirst()).setLast(all.isLast())
                    .setNumberOfElements(all.getNumberOfElements())
                    .setSize(all.getSize()).setTotalPages(all.getTotalPages())
                    .setTotalElements(all.getTotalElements()).build();
        }
        return null;
    }

    public void update(RecipeDTO recipeDTO) {
        RecipeEntity recipeEntity = recepteRepository.findById(recipeDTO.getUuid()).orElseThrow(() -> new RecipeNotFoundExeption("Такого рецепта не существует"));
        if (recipeDTO.getDtUpdate().toEpochMilli() == recipeEntity.getDtUpdate().toEpochMilli()) {
            List<Ingridients> ingredientDTOList = recipeDTO.getComposition();
            List<IngridientsEntity> list = new ArrayList<>();
            for (Ingridients s : ingredientDTOList) {
                IngridientsEntity ingridients = new IngridientsEntity(conversionService.convert(s, ProductEntity.class),
                        s.getWeight());
                list.add(ingridients);
            }
            recipeEntity.setTitle(recipeDTO.getTitle());
            recipeEntity.setComposition(list);
            recepteRepository.save(recipeEntity);
        } else throw new InvalidVersionExeption("Такой версии не существует");
    }

    @Override
    public void checkDoubleRecipe(RecipeCreatedForCU recipe ) throws ValidationException {
        String title = recipe.getTitle();
        if (recepteRepository.getAllByTitle(title) != null){
            throw new ValidationException("Product with such title has already exist");
        }
    }
}
