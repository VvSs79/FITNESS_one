package Mk.JD2_95_22.fitness.orm.repository.user;


import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByMail(String mail);
}