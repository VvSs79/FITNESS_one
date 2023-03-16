package Mk.JD2_95_22.fitness.servise.api.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

public interface IAuthenticationUserService {
    public void create(UserRegistration user);
    public void verify(String code,String mail);
    public String login(@Validated UserLogin user);
    public UserEntity find(String mail);
    public UserDTO getCard(UUID uuid);
}
