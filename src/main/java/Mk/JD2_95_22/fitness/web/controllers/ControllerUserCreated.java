package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;

import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users/registration")
public class ControllerUserCreated {

       private IUserService servise;
       @Autowired
       private IUserRepository userRepository;

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserCreated> userCreated(@RequestBody UserDTO user){
            servise.CreatedUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }


        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO user, UUID id){
            servise.getUser(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO user){
            servise.UpdateUser();
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserDTO> deleteUser(@RequestBody UserDTO user){
            servise.DeleteUser();
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
}
