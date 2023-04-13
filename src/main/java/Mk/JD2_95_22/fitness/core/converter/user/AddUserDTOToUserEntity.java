package Mk.JD2_95_22.fitness.core.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserAddDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AddUserDTOToUserEntity implements Converter<UserCreate, UserEntity> {
//    private PasswordEncoder passwordEncoder;
//
//    public AddUserDTOToUserEntity(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserEntity convert(UserCreate userCreate) {
        UserAddDTO userAddDTO = new UserAddDTO(userCreate);
        return new UserEntity(userAddDTO.getUserCreate().getMail(),
                userAddDTO.getUserCreate().getFio(),
                userAddDTO.getUserCreate().getPassword(),
                userAddDTO.getDtCreate(),
                userAddDTO.getDtUpdate(),
                new RoleEntity(userAddDTO.getUserCreate().getRole().ordinal(), userAddDTO.getUserCreate().getRole()),
                new StatusEntity(userAddDTO.getUserCreate().getStatus().ordinal(), userAddDTO.getUserCreate().getStatus()));
    }
}
