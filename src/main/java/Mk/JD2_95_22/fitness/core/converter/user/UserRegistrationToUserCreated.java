package Mk.JD2_95_22.fitness.core.converter.user;


import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationToUserCreated implements Converter<UserRegistration, UserCreate> {
//    private PasswordEncoder passwordEncoder;
//
//    public UserRegistrationToUserCreated(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
    @Override
    public UserCreate convert(UserRegistration userRegistration) {
        UserCreate userCreate = new UserCreate();
        userCreate.setMail(userRegistration.getMail());
        userCreate.setFio(userRegistration.getFio());
        userCreate.setPassword(userRegistration.getPassword());
        userCreate.setRole(String.valueOf(UserRole.USER));
        userCreate.setStatus(String.valueOf(UserStatus.WAITING_ACTIVATION));
        return userCreate;
    }
}
