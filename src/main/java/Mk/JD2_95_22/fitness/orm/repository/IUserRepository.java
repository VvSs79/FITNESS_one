package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.UUID;


public interface IUserRepository extends CrudRepository<UserEntity, UUID> {
    boolean   existsByUuidOrMail(UUID uuid,String mail);
    UserDTO findByMailIgnoreCase(String mail);
    UserDTO getAllByDtUpdate(Instant dtUpdate);
    Page<UserEntity> findAll(Pageable pageable);




}
