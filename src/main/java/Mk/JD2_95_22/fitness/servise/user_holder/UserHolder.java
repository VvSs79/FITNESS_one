package Mk.JD2_95_22.fitness.servise.user_holder;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserHolder {
    public UserDTO getUser(){
        return (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
