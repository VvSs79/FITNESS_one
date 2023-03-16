package Mk.JD2_95_22.fitness.servise.api.user;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import java.time.Instant;
import java.util.UUID;

public interface IUserService  {
    public void CreatedUser(@Validated UserCreated newUser);
    public UserDTO getUser(UUID id, String mail);
    public UserDTO getUsers(String mail);
    public void UpdateUser(UUID uuid, Instant dt_update, UserCreated userCreated);
    public void DeactivatedUserUuid(UUID uuid, String mail);
    public PageDTO<UserDTO> getPageUsers(int page, int size);
    public UserDetails loadUserByUsername(String username);
}
