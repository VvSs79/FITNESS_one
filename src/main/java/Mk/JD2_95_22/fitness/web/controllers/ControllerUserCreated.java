package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.model.UserModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;

import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.api.user.IAppUserService;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class ControllerUserCreated {

       private final IAppUserService appUserServiceservise;
       private final IUserService service;
       private final IUserRepository userRepository;

    public ControllerUserCreated(IAppUserService appUserServiceservise, IUserService service, IUserRepository userRepository) {
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
        protected ResponseEntity<PageDTO<ProductDTO>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size,
            @RequestBody Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getALL());
    }

        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO user, UUID id){
            service.getUser(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserDTO> addNewUser(@RequestBody UserCreated user, UUID id, Instant dtCreated){
            service.UpdateUser(id, dtCreated,user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserDTO> deleteUser(@RequestBody List<UserDTO> user, UUID id){
            service.DeleteUserUuid(id,user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
}
