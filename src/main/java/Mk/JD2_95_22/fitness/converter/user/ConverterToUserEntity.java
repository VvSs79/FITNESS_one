package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.orm.entity.UserRegistrationEntity;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

@Component
public class ConverterToUserEntity implements Converter<UserDTO, UserRegistrationEntity> {
    @Override
    public UserRegistrationEntity convert(UserDTO source) {
       UserDTO userDTO=new UserDTO();
       UserRegistrationEntity userEntity=new UserRegistrationEntity()

        return new UserRegistrationEntity();
    }
}

