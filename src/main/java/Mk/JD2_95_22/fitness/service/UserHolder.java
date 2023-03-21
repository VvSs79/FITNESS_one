package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    public UserJsonModel getUser(){
        return (UserJsonModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
