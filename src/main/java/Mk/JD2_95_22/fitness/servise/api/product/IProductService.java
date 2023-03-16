package Mk.JD2_95_22.fitness.servise.api.product;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
    public void createdProduct(ProductCreated product);
    public void update(ProductDTO productDTO);
    public Optional<ProductEntity> getProduct(UUID uuid);
    public ProductEntity getProducts(UUID uuid);
    public PageDTO<ProductDTO> getPageProducts(int page, int size);
}
