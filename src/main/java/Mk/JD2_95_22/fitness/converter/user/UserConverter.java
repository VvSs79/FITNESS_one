package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ModelMapper {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public UserEntity convert(UserCreated userCreated) {
        UserEntity entity=modelMapper().map(userCreated,UserEntity.class);
        return entity;
    }

    public UserCreated convert(UserEntity userEntity){
        UserCreated user=modelMapper().map(userEntity,UserCreated.class);
        return user;
    }

}

