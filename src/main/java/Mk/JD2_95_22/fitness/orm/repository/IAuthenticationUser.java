package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.UserRegistrationEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface IAuthenticationUser extends CrudRepository<UserRegistrationEntity, UUID> {
    UserRegistrationEntity findByMail(String mail);
}
