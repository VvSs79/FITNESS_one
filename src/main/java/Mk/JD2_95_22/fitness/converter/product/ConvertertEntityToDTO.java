package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ConvertertEntityToDTO implements Converter<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity source) {
        String title=source.getTitle();
        Double weight= source.getWeight();
        Double colories= source.getCalories();
        Double proteinas=source.getProteins();
        Double fats=source.getFats();
        Double carbohydrates=source.getCarbohydrates();

        return new ProductDTO(title,weight,colories,proteinas,fats,carbohydrates);
    }
}
