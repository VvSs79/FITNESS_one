package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.model.UserModel;
import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.util.UUID;

public class UserConverterEntityToModel implements Converter<UserEntity, UserModel> {
    @Override
    public UserModel convert(UserEntity source) {
        Instant dtCreate = source.getDtCreate();
        Instant dtUpdate = source.getDtUpdate();
        String fio =source.getFio();
        String mail = source.getMail();
        RoleEntity role = source.getRole();
        StatusEntity status = source.getStatus();
        UUID uuid = source.getUuid();
        return new UserModel(uuid,dtCreate,dtUpdate,fio,mail,role,status);
    }
}

