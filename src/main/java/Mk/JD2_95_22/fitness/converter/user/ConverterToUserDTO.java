package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.orm.entity.UserRegistrationEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterToUserDTO implements Converter<UserRegistrationEntity, UserCreated> {
    @Override
    public UserCreated convert(UserRegistrationEntity source) {
        UserCreated userCreated=new UserCreated(
                new BaseEssence(),
                source.getFio(),
                source.getMail(),
                source.getPassword(),
                source.getRole(),
                source.getStatus());
        UserRegistrationEntity userEntity=new UserRegistrationEntity();

    }
}
