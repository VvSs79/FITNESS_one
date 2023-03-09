package Mk.JD2_95_22.fitness.servise.api.user;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserVerification;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface IUserService  {
    public void CreatedUser(UserCreated newUser);
    public UserEntity getUser(UUID id);
    public void UpdateUser(UUID uuid, Instant dt_update, UserCreated userCreated);
    public void DeleteUserUuid(UUID uuid, List<UserDTO> user);
    public PageDTO<UserDTO> getALL(Pageable pageable);
    public void verficationUser(UserVerification verificationUser);
    public void validate( UserCreated user);
    public void  doubleCheckMail(UserCreated user);
}
