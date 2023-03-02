package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

@Component
public class ConverterToUserEntity implements Converter<UserDTO, UserEntity> {
    @Override
    public UserEntity convert( UserDTO source) {
       UserDTO userDTO=new UserDTO();
       UserEntity userEntity=new UserEntity()

        return new UserEntity();
    }
}

