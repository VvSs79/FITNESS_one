package Mk.JD2_95_22.fitness.service.api.user;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.user.UserUpdate;


import java.util.UUID;

public interface IUserService <T>{

    void create(UserCreate userDTO);

    PageDTO<T> get(int page, int size);

    UserJsonModel get(UUID id);
    UserJsonModel getUser(String mail);

    void update(UserUpdate userUpdate);

}
