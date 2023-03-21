package Mk.JD2_95_22.fitness.core.converter.user;


import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;
@Component
public class UserEntityToUserDTO implements Converter<UserEntity, UserJsonModel> {
    @Override
    public UserJsonModel convert(UserEntity userEntity) {
        UUID uuid = userEntity.getUuid();
        Instant dtCreate = userEntity.getDtCreate();
        Instant dtUpdate = userEntity.getDtUpdate();
        String mail = userEntity.getMail();
        String fio = userEntity.getFio();
        UserRole role = userEntity.getRole().getRole();
        UserStatus status = userEntity.getStatus().getStatus();
        return new UserJsonModel(uuid, dtCreate, dtUpdate, mail, fio, role, status);
    }
}
