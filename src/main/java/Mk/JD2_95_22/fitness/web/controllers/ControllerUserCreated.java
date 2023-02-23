package web.controllers;

import Mk.JD2_95_22.fitness.core.dto.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servise.api.IUserServise;

@RestController
@RequestMapping("/api/v1/users/registration")
public class ControllerUserCreated {
    final  private IUserServise servise;

    public ControllerUserCreated(IUserServise servise) {
        this.servise = servise;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> userCreated(@RequestBody User user){
        servise.CreatedUser();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestBody User user){
        servise.getUser();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        servise.UpdateUser();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        servise.DeleteUser();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
