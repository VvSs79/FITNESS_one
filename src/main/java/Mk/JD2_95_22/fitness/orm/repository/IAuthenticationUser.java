package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface IAuthenticationUser extends CrudRepository<UserEntity, UUID> {
    UserEntity findByMail(String mail);
}
