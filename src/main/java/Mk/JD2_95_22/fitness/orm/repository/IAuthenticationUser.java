package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IAuthenticationUser extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByMail(String mail);
    Optional<UserEntity> findByUuid(UUID uuid);
}
