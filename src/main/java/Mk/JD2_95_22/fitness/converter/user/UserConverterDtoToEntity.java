package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterDtoToEntity implements Converter<UserCreated, UserEntity> {
    @Override
    public UserEntity convert(UserCreated source) {

        return new UserEntity(
                source.getUuid(),
                source.getDtCreate(),
                source.getDtUpdate(),
                source.getMailUser(),
                source.getFIOuser(),
                new RoleEntity(UserRole.USER),
                new StatusEntity(UserStatus.WAITING_ACTIVATION),
                source.getPassword()
        );
   }
}
