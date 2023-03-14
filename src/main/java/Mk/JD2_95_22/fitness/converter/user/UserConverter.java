package Mk.JD2_95_22.fitness.converter.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import Mk.JD2_95_22.fitness.security.repository.RoleRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ModelMapper {
    private final RoleRepository roleRepository;

    public UserConverter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserDTO convertToUserDTO(UserEntity entity) {
        return new UserDTO(entity.getUuid(), entity.getDtCreate(),
                entity.getDtUpdate(), entity.getMail(),
                entity.getFio(), entity.getRole().getRole(), entity.getStatus().getStatus());
    }

    public UserEntity convertUserCreatedToEntity(UserCreated user) {
        UserEntity entity = new UserEntity();
        entity.setMail(user.getMailUser());
        entity.setFio(user.getFIOuser());
        entity.setRole(new RoleEntity(user.getUserRole()));
        entity.setStatus(new StatusEntity(user.getUserStatus()));
        entity.setPassword(user.getPassword());
        return entity;
    }

    public UserEntity convertUserRegistrationToEntity(UserRegistration user) {
        UserEntity entity = new UserEntity();
        entity.setMail(user.getMailUser());
        entity.setFio(user.getFIOuser());
        entity.setPassword(user.getPassword());
        entity.setRole(new RoleEntity(UserRole.USER));
        entity.setStatus(new StatusEntity(UserStatus.WAITING_ACTIVATION));
        return entity;
    }

}

