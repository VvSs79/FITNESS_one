package Mk.JD2_95_22.fitness.converter.user;


import Mk.JD2_95_22.fitness.core.dto.model.UserModel;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.UUID;

@Component
public  class ConverterToUserModel implements Converter<UserEntity, UserModel> {
    @Override
    public UserModel convert(@NonNull UserEntity source) {
        UUID uuid = source.getUuid();
        Instant dtCreated = source.getDtCreate();
        Instant dtUpdate = source.getDtUpdate();
        String mail = source.getMail();
        String fio = source.getFio();
        RoleEntity role = source.getRole();
        StatusEntity status = source.getStatus();
        return new UserModel();
    }
}
