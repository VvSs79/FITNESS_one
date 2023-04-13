package Mk.JD2_95_22.fitness.service.api.user;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;

public interface IRegistrationService {

      UserJsonModel logIn(UserLogin user);
      void create(UserRegistration user);
    void verification(String code, String mail);
    UserJsonModel getUser(String mail);


}
