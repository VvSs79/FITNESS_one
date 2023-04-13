package Mk.JD2_95_22.fitness.core.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserAddDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserRegistrationDTOToUserEntity implements Converter<UserRegistration, UserEntity> {
    public UserEntity convert(UserRegistration userRegistration) {
        UserAddDTO userAddDTO = new UserAddDTO(userRegistration);
        return new UserEntity(userAddDTO.getUserRegistrationDTO().getMail(),
                userAddDTO.getUserRegistrationDTO().getFio(),
                userAddDTO.getUserRegistrationDTO().getPassword(),
                userAddDTO.getDtCreate(),
                userAddDTO.getDtUpdate(),
                new RoleEntity(userAddDTO.getRole().ordinal(), userAddDTO.getRole()),
                new StatusEntity(userAddDTO.getStatus().ordinal(),userAddDTO.getStatus()));
    }
}
