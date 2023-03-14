package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface IPersonalUserRepository extends Repository<UserEntity, UUID> {
    UserEntity findByMail(String mail);
    void save(UserEntity entity);
    Optional<UserEntity> findByUuid(UUID uuid);
}
