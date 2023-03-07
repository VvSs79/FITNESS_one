package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.model.ProductModel;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ProductConverterModelToEntity implements Converter<ProductModel, ProductEntity> {
    @Override
    public ProductEntity convert(ProductModel source) {
        ProductEntity productEntity=new ProductEntity(
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates());

        return productEntity;
    }
}
