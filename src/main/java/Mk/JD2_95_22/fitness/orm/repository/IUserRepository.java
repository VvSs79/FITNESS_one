package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import java.time.Instant;
import java.util.UUID;


public interface IUserRepository extends CrudRepository<UserEntity, UUID> {
    boolean   existsByUuidOrMail(UUID uuid,String mail);
    UserDTO findByMailIgnoreCase(String mail);
    UserDTO getAllByDtUpdate(Instant dtUpdate);
    Page<UserEntity> findAll(Pageable pageable);




}
