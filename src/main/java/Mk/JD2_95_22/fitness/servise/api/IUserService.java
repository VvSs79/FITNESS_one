package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserVerification;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface IUserService extends UserDetailsService {
     public void CreatedUser(UserCreated newUser);
     public UserEntity getUser(UUID id);
     public void DeleteUserUuid(UUID uuid, List<UserDTO> user);
     public PageDTO<UserDTO> getALL(Pageable pageable);
     public void verficationUser(UserVerification verificationUser);
     public void validate( UserCreated user);
     public void  doubleCheckMail(UserCreated user);
}
