package Mk.JD2_95_22.fitness.core.converter.user;


import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
@Component
public class UserJsonModelToUserEntity implements Converter<UserJsonModel, UserEntity> {

    @Override
    public UserEntity convert(UserJsonModel source) {

        return new UserEntity(source.getMail(),
                source.getFio(),
                source.getPassword(),
                Instant.now(),
                Instant.now(),
                new RoleEntity(source.getRole().ordinal(),source.getRole()),
                new StatusEntity(source.getStatus().ordinal(),source.getStatus()));
    }
}
