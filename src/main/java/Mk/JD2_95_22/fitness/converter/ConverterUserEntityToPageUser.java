package Mk.JD2_95_22.fitness.converter;

import Mk.JD2_95_22.fitness.core.dto.page.Page;
import Mk.JD2_95_22.fitness.core.dto.user.User;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterUserEntityToPageUser implements Converter<UserEntity, Page<User>>{
    @Override
    public Page<User> convert(UserEntity source) {
        return new Page<User>();
    }
}
