package Mk.JD2_95_22.fitness.converter;

import Mk.JD2_95_22.fitness.core.dto.model.ProductModel;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterProductEntityToProductMadel implements Converter<ProductEntity, ProductModel> {
    @Override
    public ProductModel convert(ProductEntity source) {
        return new ProductModel();
    }
}
