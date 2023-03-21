package Mk.JD2_95_22.fitness.orm.repository.product;

import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, UUID> {
    ProductEntity findByTitle(String title);
}
