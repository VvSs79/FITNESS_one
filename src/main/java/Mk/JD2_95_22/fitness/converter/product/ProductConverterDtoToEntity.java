package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class ProductConverterDtoToEntity implements Converter<ProductDTO, ProductEntity>  {
    @Override
    public ProductEntity convert(ProductDTO source) {

        return new ProductEntity(
                UUID.randomUUID(),
                Instant.now(),
                Instant.now(),
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates());
    }
}
