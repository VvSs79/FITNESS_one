package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.converter.product.ProductConverterEntityToModel;
import Mk.JD2_95_22.fitness.converter.product.ProductConverterModelToEntity;
import Mk.JD2_95_22.fitness.core.dto.model.IngridientsModel;
import Mk.JD2_95_22.fitness.core.dto.model.ReceptModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.Ingridients;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeCreated;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import Mk.JD2_95_22.fitness.orm.entity.IngridientsEntity;
import Mk.JD2_95_22.fitness.orm.entity.RecepteEntity;
import Mk.JD2_95_22.fitness.orm.repository.IRecepteRepository;
import Mk.JD2_95_22.fitness.servise.api.IProductService;
import Mk.JD2_95_22.fitness.servise.api.IRecepteService;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RecepteService implements IRecepteService {
    private final IRecepteRepository repository;
    private final IProductService service;
    private final ProductConverterEntityToModel productConverterEntityToModel;
    private final ProductConverterModelToEntity productConverterModelToEntity;

    public RecepteService(IRecepteRepository repository, IProductService service, ProductConverterEntityToModel productConverterEntityToModel, ProductConverterModelToEntity productConverterModelToEntity) {
        this.repository = repository;
        this.service = service;
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
?                .collect(Collectors.toList());
        RecepteEntity recipeEntity = new RecepteEntity();
        repository.save(recipeEntity);
    }

    @Override
    public PageDTO<RecipeDTO> getPageRecipe(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<RecepteEntity> all = repository.findAll(paging);
        List<ReceptModel>  content  = new ArrayList<>();
        for (RecepteEntity recipe: all.getContent()) {
            List<IngridientsModel> collect = recipe.getComposition().stream()
                    .map(s -> new IngridientsModel(
                            service.getProduct(s.getProduct().getUuid()),
                            s.getWeight()))
                    .collect(Collectors.toList());
            Integer weight = collect.stream()
                    .mapToInt(IngridientsModel::getWeight).sum();
            Integer calories = collect.stream()
                    .mapToInt(IngridientsModel::getCalories).sum();
            Double proteins = collect.stream()
                    .mapToDouble(IngridientsModel::getProteins).sum();
            Double fats = collect.stream()
                    .mapToDouble(IngridientsModel::getFats).sum();
            Double carbohydrates = collect.stream()
                    .mapToDouble(IngridientsModel::getCarbohydrates).sum();
            content.add(
                    new ReceptModel(recipe.getUuid(),
                            recipe.getTimeCreated()),
                            recipe.getDt_update(),
                            recipe.getTitle(),
                            collect,
                            weight,
                            calories,
                            proteins,
                            fats,
                            carbohydrates
                    );
        } return  new PageDTO<RecipeDTO>(
                all.getNumber(),
                all.getSize(),
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                all.getNumber());
    }

    @Override
    public void update(UUID id, Instant version, RecipeDTO product) {
        checkDoubleRecipe(product);
        validate(product);
        RecepteEntity recipeEntity = repository.findById(id)
                .orElseThrow(() -> new ValidationException("There is no recipe with such id"));
        if (version.toEpochMilli() == recipeEntity.getDt_update().toEpochMilli()){
            recipeEntity.setTitle(product.getTitle());
            List<Ingridients> composition = product.getComposition();
            List<IngridientsEntity> collect = composition.stream()
                    .map(s -> new IngridientsEntity(
                            productConverterModelToEntity.convert(service.getProduct(s.get)), s.getWeight()))
                    .collect(Collectors.toList());
            recipeEntity.setComposition(collect);
            repository.save(recipeEntity);
        }  else throw new ValidationException("Version is not correct");
    }
    public void validate(RecipeDTO recipe) throws ValidationException {
        String title = recipe.getTitle();

        if (title == null || title.isBlank()){
            throw new ValidationException("Title of product is not entered");
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
        if (repository.getByTitle(title) != null){
            throw new ValidationException("Product with such title has already exist");
        }
    }
}
