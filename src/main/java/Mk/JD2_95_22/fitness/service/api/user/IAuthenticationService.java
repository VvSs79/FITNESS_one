package Mk.JD2_95_22.fitness.service.api.user;


import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;

public interface IAuthenticationService {
//    UserJsonModel logIn(UserLogin userLogin);
//
//    void registration(UserRegistration userRegistration);
//
//    void verification(String code,String mail);
//
//    UserAddDTO getCard(UUID uuid);
      UserJsonModel logIn(UserLogin user);
      void registration(UserRegistration user);
    void verification(String code, String mail);


}
