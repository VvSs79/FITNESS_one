package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.TokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ITokenRepository extends CrudRepository<TokenEntity, UUID> {
    TokenEntity findByConfirmationToken(String confirmationToken);
}
