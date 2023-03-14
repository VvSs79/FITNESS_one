package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
  UserDetails userDetails;
  private IAuthenticationService service;

  private IUserAuthenticationService userAuthenticationService;

  public AuthController(IUserAuthenticationService userAuthenticationService) {

    this.userAuthenticationService = userAuthenticationService;
  }

  @PostMapping("/registration")
  public ResponseEntity<String> register(@Valid @RequestBody UserRegistration userRegistration) {

    this.userAuthenticationService.register(userRegistration);
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

    String jwtToken = this.userAuthenticationService.login(userLogin);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(jwtToken);
  }

  @GetMapping("/me")
  public ResponseEntity<UserDTO> getMyData() {

    UserDTO userData = this.userAuthenticationService.getMyData();
    return ResponseEntity.ok(userData);
  }
}
