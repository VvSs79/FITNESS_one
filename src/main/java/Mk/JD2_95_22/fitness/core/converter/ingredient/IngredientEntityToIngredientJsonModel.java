package Mk.JD2_95_22.fitness.core.converter.ingredient;

import Mk.JD2_95_22.fitness.core.converter.product.ProductEntityConverterToProductJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.IngredientJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.IngredientEntity;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Component
public class IngredientEntityToIngredientJsonModel  implements Converter<IngredientEntity, IngredientJsonModel> {
    private final ProductEntityConverterToProductJsonModel conversion;
    public IngredientEntityToIngredientJsonModel(ProductEntityConverterToProductJsonModel conversion) {
        this.conversion = conversion;
    }

    @Override
    public IngredientJsonModel convert(IngredientEntity source) {
        ProductJsonModel product=conversion.convert(source.getProduct());

        int ingredientWeight=source.getWeight();
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        ProductEntity productEntity=source.getProduct();
        BigDecimal coefficient = BigDecimal.valueOf(ingredientWeight).divide(BigDecimal
                .valueOf(productEntity.getWeight()), scale, roundingMode);

        Integer calories=BigDecimal.valueOf(productEntity.getCalories()).multiply(coefficient).intValue();
        Double proteins=BigDecimal.valueOf(productEntity.getProteins()).multiply(coefficient)
                .setScale(scale, roundingMode).doubleValue();
        Double fats=BigDecimal.valueOf(productEntity.getFats()).multiply(coefficient)
                .setScale(scale, roundingMode).doubleValue();
        Double carbohydrates= BigDecimal.valueOf(productEntity.getCarbohydrates()).multiply(coefficient)
                .setScale(scale, roundingMode).doubleValue();

        return new IngredientJsonModel(product,
                ingredientWeight,
                calories,
                proteins,
                fats,
                carbohydrates);
    }
}
