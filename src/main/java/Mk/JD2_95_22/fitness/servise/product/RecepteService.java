package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.converter.product.ProductConverterEntityToModel;
import Mk.JD2_95_22.fitness.converter.product.ProductConverterModelToEntity;
import Mk.JD2_95_22.fitness.core.dto.model.ProductModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.Ingridients;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.IngridientsEntity;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import Mk.JD2_95_22.fitness.orm.entity.product.RecipeEntity;
import Mk.JD2_95_22.fitness.orm.repository.IIngridientsRepoitory;
import Mk.JD2_95_22.fitness.orm.repository.IRecepteRepository;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import Mk.JD2_95_22.fitness.servise.api.product.IRecepteService;
import Mk.JD2_95_22.fitness.servise.my_exeption.product.RecipeNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.version.InvalidVersionExeption;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.ValidationException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RecepteService implements IRecepteService {
    private final IRecepteRepository recepteRepository;
    private final IProductService service;
    private final IIngridientsRepoitory ingridientsRepoitory;
    private final ConversionService conversionService;
    private final ProductConverterEntityToModel productConverterEntityToModel;
    private final ProductConverterModelToEntity productConverterModelToEntity;

    public RecepteService(IRecepteRepository recepteRepository, IProductService service, IIngridientsRepoitory ingridientsRepoitory, ConversionService conversionService, ProductConverterEntityToModel productConverterEntityToModel, ProductConverterModelToEntity productConverterModelToEntity) {
        this.recepteRepository = recepteRepository;
        this.service = service;
        this.ingridientsRepoitory = ingridientsRepoitory;
        this.conversionService = conversionService;
        this.productConverterEntityToModel = productConverterEntityToModel;
        this.productConverterModelToEntity = productConverterModelToEntity;
    }

    @Override
    public void create(RecipeDTO recipe) {
        validate(recipe);
        checkDoubleRecipe(recipe);
        RecipeDTO recipes = new RecipeDTO(recipe.getTitle(), recipe.getComposition());
        List<Ingridients> ingredientDTO = recipes.getComposition();
        List<Ingridients> collect = ingredientDTO.stream()
               .collect(Collectors.toList());
        RecipeEntity recipeEntity = new RecipeEntity();
        recepteRepository.save(recipeEntity);
    }

    public PageDTO<RecipeDTO> getPageRecipe(Pageable pageable){
        Page<RecipeEntity> allPages=recepteRepository.findAll(pageable);
        List<RecipeDTO> content= new ArrayList<>();
        for(RecipeEntity recipeEntity:allPages){
            content.add(conversionService.convert(recipeEntity,RecipeDTO.class));
        }
        return new PageDTO<>(allPages.getNumber(),
                allPages.getSize(),
                allPages.getTotalPages(),
                allPages.getTotalElements(),
                allPages.isFirst(),
                allPages.getNumberOfElements(),
                allPages.isLast(),
                content);
    }

    @Override
    public void update(UUID id, Instant version, RecipeDTO product, String title) {
        if(version==null){
            throw new InvalidVersionExeption("version is not correct");
        }
        checkDoubleRecipe(product);
        validate(product);
        RecipeEntity recipeEntity = recepteRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundExeption("There is no recipe with such id"));

        if(recipeEntity.getDtUpdate().toEpochMilli()!=version.toEpochMilli()){
            throw  new OptimisticLockException("Version "+ recipeEntity.getUuid() +"is not corrected");
        }
      if(!conversionService.canConvert(ProductModel.class, ProductEntity.class)){
          throw new IllegalArgumentException("Can't converting ProductModel to ProductEntity ");
      }
        if(recepteRepository.getAllByUuid(id).equals(version)){
            throw  new ValidationException("This is not actual version");
        }
        List<IngridientsEntity> ingredientEntityList = new ArrayList<>();
        List<Ingridients> ingredientList = product.getComposition();



        for (Ingridients ingredient : ingredientList) {
            if(ingredient!=null){
                ProductEntity productEntity = service.getProduct(id,conversionService.convert(product,ProductEntity.class));
                ingredientEntityList.add(new IngridientsEntity(productEntity, ingredient.getWeight()));
            }
        }
        recipeEntity.setTitle(product.getTitle());
        recipeEntity.setComposition(ingredientEntityList);

        recepteRepository.save(recipeEntity);
    }



    public void validate(RecipeDTO recipe) throws ValidationException {
        String title = recipe.getTitle();

        if (title == null || title.isBlank()){
            throw new ValidationException("This recipe with this is a product is not entered");
        }
        List<Ingridients> composition = recipe.getComposition();

        for (Ingridients ingredient:composition) {
            if (ingredient== null){
                throw new ValidationException("Product with id "+ ingredient+" is not exist");
            }
            if (ingredient.getWeight() <=0 ){
                throw new ValidationException("Weight of ingredient with id "+ ingredient.getWeight()+ " is incorrect");
            }

        }
    }

    public void checkDoubleRecipe(RecipeDTO recipe) throws ValidationException {
        String title = recipe.getTitle();
        if (recepteRepository.getAllByTitle(title) != null){
            throw new ValidationException("Product with such title has already exist");
        }
    }



    private RecipeDTO countRecipeCPFC(List<Ingridients> ingredient, RecipeDTO recipe) {
        int weight = 0;
        int calories = 0;
        double proteins = 0;
        double fats = 0;
        double carbohydrates = 0;
        for (Ingridients dto : ingredient) {
            weight += dto.getProduct().getWeight();
            calories += dto.getProduct().getCalories();
            proteins += dto.getProduct().getProteins();
            fats += dto.getProduct().getFats();
            carbohydrates += dto.getProduct().getCarbohydrates();
        }
        return new RecipeDTO(recipe.getTitle(),recipe.getComposition());
    }
}
