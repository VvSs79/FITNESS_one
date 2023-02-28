package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface IProductRepositpry extends CrudRepository<ProductEntity, UUID> {
}
