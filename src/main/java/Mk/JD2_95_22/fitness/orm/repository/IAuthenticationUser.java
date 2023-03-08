package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAuthenticationUser extends JpaRepository<UserEntity, UUID> {
    UserEntity findByMail(String mail);
}
