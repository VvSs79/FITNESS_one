package Mk.JD2_95_22.fitness.service.api.product;

import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.product.ProductCreate;
import Mk.JD2_95_22.fitness.core.dto.product.ProductUpdate;

import java.util.UUID;


public interface IProductService<T> {
    void create(ProductCreate productDTO);

    PageDTO<T> get(int page, int size);

    void update(ProductUpdate productDTO);
    ProductJsonModel get(UUID id);
}
