package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.mail.MailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IMailRepository extends CrudRepository<MailEntity, UUID> {
    MailEntity findByEmailTo_Uuid(UUID uuid);

}
