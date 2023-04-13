package Mk.JD2_95_22.fitness.core.converter.product;

import Mk.JD2_95_22.fitness.core.dto.j_model.IngredientJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.RecipeJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.IngredientEntity;
import Mk.JD2_95_22.fitness.orm.entity.RecipeEntity;
import org.hibernate.tuple.InDatabaseValueGenerationStrategy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class RecipeJsonModelToRecipeEntity implements Converter<RecipeJsonModel, RecipeEntity> {
    private final ConversionService conversionService;
    public RecipeJsonModelToRecipeEntity(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public RecipeEntity convert(RecipeJsonModel source) {
        List<IngredientEntity> list=new ArrayList<>();
        IngredientEntity ingredientEntity=conversionService.convert(source.getComposition(), IngredientEntity.class);
        list.add(ingredientEntity);
        return new RecipeEntity(source.getUuid(),
                source.getDtCreate(),
                source.getDtUpdate(),
                source.getTitle(),
                list);
    }
}
