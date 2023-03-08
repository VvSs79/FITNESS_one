package Mk.JD2_95_22.fitness.servise.api.product;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;

import java.util.UUID;

public interface IProductService {
    public void addProduct(ProductDTO productCreateDTO);
    public void update(UUID uuid, long dtUpdate, ProductCreated productCreateDTO);
    public PageDTO<ProductDTO> getPage(int numberOfPage, int size);
    public void getProduct();

}
