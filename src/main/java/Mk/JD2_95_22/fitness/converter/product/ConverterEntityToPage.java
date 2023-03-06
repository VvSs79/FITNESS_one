package Mk.JD2_95_22.fitness.converter.product;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterEntityToPage implements Converter<ProductEntity, PageDTO<ProductDTO>> {
    @Override
    public PageDTO<ProductDTO> convert(ProductEntity source) {

        return new PageDTO<ProductDTO>();
    }
}

