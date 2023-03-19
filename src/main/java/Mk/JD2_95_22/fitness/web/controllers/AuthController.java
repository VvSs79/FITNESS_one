package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.orm.repository.IAuthenticationUser;
import Mk.JD2_95_22.fitness.servise.api.user.IAuthenticationUserService;
import Mk.JD2_95_22.fitness.servise.user_holder.UserHolder;
import Mk.JD2_95_22.fitness.web.util.JwtTokenHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
  private IAuthenticationUser repository;
  private UserHolder userHolder;
//  private final JwtTokenHandler jwtTokenUtil;
//
  private IAuthenticationUserService service;

  public AuthController(IAuthenticationUser repository, IAuthenticationUserService service) {
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
  public String login(@Valid @RequestBody UserLogin userLogin) {
      UserDTO user = service.login(userLogin);

      return JwtTokenHandler.generateAccessToken(user);
  }

  @GetMapping(path = "/me")
  public UserDTO getUser() {
    UUID uuid=userHolder.getUser().getUuid();
    return service.getCard(uuid);
  }
}
