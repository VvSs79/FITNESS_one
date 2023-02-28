package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.Page;
import Mk.JD2_95_22.fitness.core.dto.user.User;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import java.awt.print.Pageable;
import java.time.Instant;
import java.util.UUID;

public interface IAdminRoot {
    void add(UserCreated newUser);
    Page<User> getAll(Pageable page);
    Page getUser(UUID id, String mail);
    Page getUsers(UserStatus status);
    void updateUsers(UUID id, Instant timeLastUpdate, UserCreated user);
    void deleteUser(UUID id, String mail);
    void setUserStatus(Page<User> page, String mail);

}
