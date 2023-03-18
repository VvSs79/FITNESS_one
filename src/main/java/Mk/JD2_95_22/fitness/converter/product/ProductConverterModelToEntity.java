package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.model.ProductJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterModelToEntity implements Converter<ProductJsonModel, ProductEntity> {
    @Override
    public ProductEntity convert(ProductJsonModel source) {
        ProductJsonModel productModel=new ProductJsonModel(
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
