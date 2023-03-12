package Mk.JD2_95_22.fitness.servise.api.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;

import java.util.UUID;

public interface IAuthenticationUserervice {
    void addUser(UserRegistration userRegistration);

    void verification(String email, String code);

    UserDTO loging(UserLogin userLogin);

    UserDTO getCard(UUID uuid);
}
