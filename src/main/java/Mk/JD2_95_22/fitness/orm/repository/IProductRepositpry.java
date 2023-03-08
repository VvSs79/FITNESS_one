package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.UUID;

public interface IProductRepositpry extends JpaRepository<ProductEntity, UUID> {
    PageDTO<ProductDTO> getAllByDtUpdate(Instant dtUpdate);
    PageDTO<ProductDTO> getAllByCalories(Double calories);
    PageDTO<ProductDTO> getAllByCarbohydrates(Double calories);
    PageDTO<ProductDTO> getAllByCaloriesIsGreaterThan(Double calories);

}
