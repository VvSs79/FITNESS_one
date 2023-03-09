package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.product.IngridientsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IIngridientsRepoitory extends CrudRepository<IngridientsEntity, UUID> {
    List<IngridientsEntity> findAllBy(String title);
}
