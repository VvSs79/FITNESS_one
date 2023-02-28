package Mk.JD2_95_22.fitness.converter;

import Mk.JD2_95_22.fitness.core.dto.products.Product;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterProductEntityToProduct implements Converter<ProductEntity, Product> {
    @Override
    public Product convert(ProductEntity source) {
        return new Product();
    }
}
