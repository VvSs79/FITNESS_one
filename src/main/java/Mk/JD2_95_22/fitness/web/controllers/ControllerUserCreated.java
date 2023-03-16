package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import org.springframework.data.domain.Pageable;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.api.user.IAuthenticationUserService;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class ControllerUserCreated {

       private final IAuthenticationUserService appUserServiceservise;
       private final IUserService service;
       private final IUserRepository userRepository;

    public ControllerUserCreated(IAuthenticationUserService appUserServiceservise, IUserService service, IUserRepository userRepository) {
        this.appUserServiceservise = appUserServiceservise;
        this.service = service;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserCreated> userCreated(@RequestBody UserCreated user){
           service.CreatedUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

    @RequestMapping(method = RequestMethod.GET)
        protected ResponseEntity<PageDTO<UserDTO>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {
        Pageable paging= PageRequest.of(page,size);
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getPageUsers(page,size));
    }

        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO user, UUID id, String mail){
            service.getUser(id, mail);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserDTO> addNewUser(@RequestBody UserCreated user, UUID id, Instant dtCreated){
            service.UpdateUser(id, dtCreated,user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserDTO> deleteUser(@RequestBody List<UserDTO> user, UUID id, String mail){
            service.DeactivatedUserUuid(id, mail);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
}
