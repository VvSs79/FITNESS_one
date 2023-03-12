package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface IProductRepositpry extends JpaRepository<ProductEntity, UUID> {
    boolean existsByTitle(String title);

    ProductEntity getAllByDtUpdate(Instant dtUpdate);
    Optional<ProductEntity> getAllByTitle(String title);
    Optional<ProductEntity> getByTitleIgnoreCase(String title);
//    ProductEntity getAllByTitleAndDtUpdate(String title, Instant dtUpdate);
    Optional<ProductEntity> getAllByTitleAndDtUpdate(String title, Instant dtUpdate);
    ProductEntity deleteAllByTitle(String title);
    ProductEntity getAllByUuid(UUID uuid);



}
