package Mk.JD2_95_22.fitness.core.converter.product;

import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityConverterToProductJsonModel implements Converter<ProductEntity, ProductJsonModel> {
    @Override
    public ProductJsonModel convert(ProductEntity productEntity) {
        return new ProductJsonModel(
                productEntity.getUuid(),
                productEntity.getDtCreate(),
                productEntity.getDtUpdate(),
                productEntity.getTitle(),
                productEntity.getWeight(),
                productEntity.getCalories(),
                productEntity.getProteins(),
                productEntity.getFats(),
                productEntity.getCarbohydrates());
    }
}
