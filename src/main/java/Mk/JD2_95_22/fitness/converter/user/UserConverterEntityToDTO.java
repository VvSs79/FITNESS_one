package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.util.UUID;

public class UserConverterEntityToDTO implements Converter<UserEntity, UserDTO> {
    @Override
    public UserDTO convert(UserEntity source) {
                UUID uuid=source.getUuid();
                Instant dtCreated=source.getDtCreate();
                Instant dtUpdate= source.getDtUpdate();
                String fio =source.getFio();
                String mail = source.getMail();
                UserRole role=UserRole.USER;
                UserStatus status=UserStatus.WAITING_ACTIVATION;

        return new UserDTO(uuid,dtCreated,dtUpdate,mail,fio,role,status);
    }
}
