package Mk.JD2_95_22.fitness.core.converter.product;

import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductJsonModelConverterToProductEntity implements Converter<ProductJsonModel, ProductEntity> {

    @Override
    public ProductEntity convert(ProductJsonModel productJsonModel) {
        return new ProductEntity(
                productJsonModel.getUuid(),
                productJsonModel.getDtCreate(),
                productJsonModel.getDtUpdate(),
                productJsonModel.getTitle(),
                productJsonModel.getWeight(),
                productJsonModel.getCalories(),
                productJsonModel.getProteins(),
                productJsonModel.getFats(),
                productJsonModel.getCarbohydrates());
    }
}
