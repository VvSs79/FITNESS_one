package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.RecepteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IRecepteRepository extends CrudRepository<RecepteEntity, UUID> {
}
