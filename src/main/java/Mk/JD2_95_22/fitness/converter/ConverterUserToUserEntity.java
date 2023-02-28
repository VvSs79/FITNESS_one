package Mk.JD2_95_22.fitness.converter;

import Mk.JD2_95_22.fitness.core.dto.user.User;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public class ConverterUserToUserEntity implements Converter<User, UserEntity> {
    @Override
    public UserEntity convert(@NonNull User source) {
        return new UserEntity();
    }
}

