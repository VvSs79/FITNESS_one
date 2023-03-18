package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.model.UserJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.util.UUID;

public class UserConverterEntityToModel implements Converter<UserEntity, UserJsonModel> {
    @Override
    public UserJsonModel convert(UserEntity source) {
        Instant dtCreate = source.getDtCreate();
        Instant dtUpdate = source.getDtUpdate();
        String fio =source.getFio();
        String mail = source.getMail();
        RoleEntity role = source.getRole();
        StatusEntity status = source.getStatus();
        UUID uuid = source.getUuid();
        return new UserJsonModel(uuid,dtCreate,dtUpdate,fio,mail,role,status);
    }
}

