package Mk.JD2_95_22.fitness.core.converter.product;

import Mk.JD2_95_22.fitness.core.dto.product.ProductAddDTO;
import Mk.JD2_95_22.fitness.core.dto.product.ProductCreate;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductCreateConverterToProductEntity implements Converter<ProductCreate, ProductEntity> {
    @Override
    public ProductEntity convert(ProductCreate productCreate) {
        ProductAddDTO productAddDTO = new ProductAddDTO(productCreate);
        return new ProductEntity(
                productAddDTO.getDtCreate(),
                productAddDTO.getDtUpdate(),
                productAddDTO.getAddProductDTO().getTitle(),
                productAddDTO.getAddProductDTO().getWeight(),
                productAddDTO.getAddProductDTO().getCalories(),
                productAddDTO.getAddProductDTO().getProteins(),
                productAddDTO.getAddProductDTO().getFats(),
                productAddDTO.getAddProductDTO().getCarbohydrates());
    }
}
