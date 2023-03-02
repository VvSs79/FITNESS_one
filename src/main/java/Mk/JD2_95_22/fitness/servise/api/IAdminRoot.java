package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import java.awt.print.Pageable;
import java.time.Instant;
import java.util.UUID;

public interface IAdminRoot {
    void add(UserCreated newUser);
    PageDTO<UserDTO> getAll(Pageable page);
    PageDTO getUser(UUID id, String mail);
    PageDTO getUsers(UserStatus status);
    void updateUsers(UUID id, Instant timeLastUpdate, UserCreated user);
    void deleteUser(UUID id, String mail);
    void setUserStatus(PageDTO<UserDTO> page, String mail);

}
