package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class UserConverterEntityToDTO implements Converter<UserEntity, UserDTO> {
    @Override
    public UserDTO convert(UserEntity source) {
        String fio =source.getFio();
        String mail = source.getMail();
        UserRole role=source.getRole();
        UserStatus status=source.getStatus();
        UUID uuid = source.getUuid();
        return new UserDTO(mail,fio,role,status);
    }
}
