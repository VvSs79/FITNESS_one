package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;

import java.util.UUID;

public interface IUserServise {
     void CreatedUser(UserDTO newUser);
     void getUser(UUID id);
     void UpdateUser();
     void DeleteUser();
     void exist();
     void validate();
}
