package Mk.JD2_95_22.fitness.servise.api.product;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface IProductService {
    public void addProduct(ProductDTO product);
    public void update(UUID uuid, Instant dtUpdate, ProductCreated productCreate);
    public PageDTO<ProductDTO> getPage(int numberOfPage, int size);
    public ProductEntity getProduct(UUID uuid, ProductEntity productEntity);
    Optional<ProductEntity> getProductUuid(UUID uuid);
}
