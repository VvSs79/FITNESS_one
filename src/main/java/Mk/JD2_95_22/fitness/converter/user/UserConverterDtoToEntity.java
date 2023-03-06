package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserConverterDtoToEntity implements Converter<UserCreated, UserEntity> {
    @Override
    public UserEntity convert(UserCreated source) {
        UserCreated user=new UserCreated(
                source.getFIOuser(),
                source.getMailUser(),
                source.getPassword(),
                source.getUserRole(),
                source.getUserStatus());
        UserEntity userEntity=new UserEntity(
                user.getMailUser(),
                user.getFIOuser(),
               new RoleEntity(),
               new StatusEntity(),
                user.getPassword());
        return userEntity;
    }
}
