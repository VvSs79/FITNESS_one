package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.util.UUID;


public class UserConverterDtoToEntity implements Converter<UserCreated, UserEntity> {
    @Override
    public UserEntity convert(UserCreated source) {

//         UUID uuid=source.getUuid();
//         Instant dtCreate=source.getDtCreate();
//         Instant dtUpdate=source.getDtUpdate();
//         String mail= source.getMailUser();
//         String fio=source.getFIOuser();
//         UserRole role=UserRole.USER;
//         UserStatus status=UserStatus.WAITING_ACTIVATION;
//         String password= source.getPassword();
       return new UserEntity(
               UUID.randomUUID(),
               Instant.now(),
               Instant.now(),
               source.getMailUser(),
               source.getFIOuser(),
               source.getUserRole(),
               source.getUserStatus(),
               source.getPassword()
       );


    }
}
