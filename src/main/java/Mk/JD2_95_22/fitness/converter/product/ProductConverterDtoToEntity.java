package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterDtoToEntity implements Converter<ProductDTO, ProductEntity>  {

    @Override
    public ProductEntity convert(ProductDTO source) {
        ProductDTO productDTO=new ProductDTO(
                source.getUuid(),
                source.getDtCreate(),
                source.getDtUpdate(),
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates());
        ProductEntity productEntity=new ProductEntity(
                productDTO.getUuid(),
                productDTO.getDtCreate(),
                productDTO.getDtUpdate(),
                productDTO.getTitle(),
                productDTO.getWeight(),
                productDTO.getCalories(),
                productDTO.getProteins(),
                productDTO.getFats(),
                productDTO.getCarbohydrates());
        return productEntity;
    }

}
