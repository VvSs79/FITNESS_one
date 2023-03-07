package Mk.JD2_95_22.fitness.servise.root;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.servise.api.IAdminRoot;

import java.awt.print.Pageable;
import java.time.Instant;
import java.util.UUID;

public class AdminRoot implements IAdminRoot {
    @Override
    public void add(UserCreated newUser) {

    }

    @Override
    public PageDTO<UserDTO> getAll(Pageable page) {
        return null;
    }

    @Override
    public PageDTO getUser(UUID id, String mail) {
        return null;
    }

    @Override
    public PageDTO getUsers(UserStatus status) {
        return null;
    }

    @Override
    public void updateUsers(UUID id, Instant timeLastUpdate, UserCreated user) {

    }

    @Override
    public void deleteUser(UUID id, String mail) {

    }

    @Override
    public void setUserStatus(PageDTO<UserDTO> page, String mail) {

    }
}
