package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.UUID;

public interface IProductService {
    void add (ProductCreated newProduct);
    PageDTO<ProductDTO> getAll(Pageable pageable);
    void update(UUID uuid, Instant dt_update,ProductCreated productCreated);
}
