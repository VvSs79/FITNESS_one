package Mk.JD2_95_22.fitness.core.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserAddDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class AddUserDTOToUserEntity implements Converter<UserCreate, UserEntity> {

    @Override
    public UserEntity convert(UserCreate userCreate) {
        UserAddDTO userAddDTO = new UserAddDTO(userCreate);
        return new UserEntity(userAddDTO.getUserDTO().getMail(),
                userAddDTO.getUserDTO().getFio(),
                userAddDTO.getUserDTO().getPassword(),
                userAddDTO.getDtCreate(),
                userAddDTO.getDtUpdate(),
                new RoleEntity(userAddDTO.getUserDTO().getRole()),
                new StatusEntity(userAddDTO.getUserDTO().getStatus()));
    }
}
