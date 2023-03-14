package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Component
public class ProductConvertertEntityToDTO implements Converter<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity source) {
        UUID uuid=source.getUuid();
        Instant dtCreate=source.getDtCreate();
        Instant dtUpdate=source.getDtUpdate();
        String title=source.getTitle();
        Integer weight= source.getWeight();
        BigDecimal colories= source.getCalories();
        BigDecimal proteinas=source.getProteins();
        BigDecimal fats=source.getFats();
        BigDecimal carbohydrates=source.getCarbohydrates();

        return new ProductDTO(uuid,dtCreate, dtUpdate,title,weight,colories,proteinas,fats,carbohydrates);
    }
}
