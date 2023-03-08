package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.model.ProductModel;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterModelToEntity implements Converter<ProductModel, ProductEntity> {
    @Override
    public ProductEntity convert(ProductModel source) {
        ProductModel productModel=new ProductModel(
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
                productModel.getUuid(),
                productModel.getDtCreate(),
                productModel.getDtUpdate(),
                productModel.getTitle(),
                productModel.getWeight(),
                productModel.getCalories(),
                productModel.getProteins(),
                productModel.getFats(),
                productModel.getCarbohydrates()
        );
        return productEntity;
    }
}
