package Mk.JD2_95_22.fitness.core.converter.ingredient;

import Mk.JD2_95_22.fitness.core.dto.j_model.IngredientJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.IngredientEntity;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class IngredientJsonModelToIngredientEntity implements Converter<IngredientJsonModel, IngredientEntity> {
    private final ConversionService conversionService;

    public IngredientJsonModelToIngredientEntity(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public IngredientEntity convert(IngredientJsonModel source) {
        ProductEntity productEntity=conversionService.convert(source.getProduct(), ProductEntity.class);
        return  new IngredientEntity(
                productEntity,
                source.getWeight());
    }
}
