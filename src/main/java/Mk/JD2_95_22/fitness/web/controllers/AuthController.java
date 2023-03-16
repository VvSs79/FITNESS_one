package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.orm.repository.IAuthenticationUser;
import Mk.JD2_95_22.fitness.servise.api.user.IAuthenticationUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
  UserDetails userDetails;
  private IAuthenticationUser repository;

  private IAuthenticationUserService service;

  public AuthController(UserDetails userDetails, IAuthenticationUser repository, IAuthenticationUserService service) {
    this.userDetails = userDetails;
    this.repository = repository;
    this.service = service;
  }

  @PostMapping("/registration")
  public ResponseEntity<String> register(@Valid @RequestBody UserRegistration userRegistration) {

    this.service.create(userRegistration);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }

  @GetMapping("/verification")
  public ResponseEntity<String> verifyCode(@RequestParam String code,
                                           @RequestParam String mail) {

    //TODO: implement mail verification functionality
    return ResponseEntity.ok("User successfully verified");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@Valid @RequestBody UserLogin userLogin) {

    String jwtToken = this.service.login(userLogin);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(jwtToken);
  }

  @GetMapping("/me")
  public ResponseEntity<UserDTO> getMyData(UUID uuid) {

    UserDTO userData = this.service.getCard(uuid);
    return ResponseEntity.ok(userData);
  }
}
