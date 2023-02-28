package Mk.JD2_95_22.fitness.servise;

import Mk.JD2_95_22.fitness.core.dto.page.Page;
import Mk.JD2_95_22.fitness.core.dto.user.User;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.servise.api.IAdminRoot;

import java.awt.print.Pageable;
import java.time.Instant;
import java.util.UUID;

public class AdminServise implements IAdminRoot {
    @Override
    public void add(UserCreated newUser) {

    }

    @Override
    public Page<User> getAll(Pageable page) {
        return null;
    }

    @Override
    public Page getUser(UUID id, String mail) {
        return null;
    }

    @Override
    public Page getUsers(UserStatus status) {
        return null;
    }

    @Override
    public void updateUsers(UUID id, Instant timeLastUpdate, UserCreated user) {

    }

    @Override
    public void deleteUser(UUID id, String mail) {

    }

    @Override
    public void setUserStatus(Page<User> page, String mail) {

    }
}
