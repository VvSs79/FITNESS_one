package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.core.dto.user.User;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.data.repository.Repository;
import java.util.UUID;


public interface IUserRepository extends Repository<UserEntity, UUID> {
    boolean   existsByUuidOrMail(UUID uuid,String mail);
    User findByMailIgnoreCase(String mail);



}
