package Mk.JD2_95_22.fitness.service.api.product;

import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductCreate;
import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductUpdate;
import java.util.UUID;


public interface IProductService<T> {

UUID create(ProductCreate productDTO);
    PageDTO<ProductJsonModel> getPageProducts(int page, int size);
    UUID update(ProductUpdate productDTO);
    ProductJsonModel getProduct(UUID id);
}
