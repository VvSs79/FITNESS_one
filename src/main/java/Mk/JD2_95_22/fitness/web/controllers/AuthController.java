package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.servise.api.user.IAuthenticationUserService;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.user_holder.UserHolder;
import Mk.JD2_95_22.fitness.web.util.JwtTokenHandler;
import jakarta.validation.Valid;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
  private  final JwtTokenHandler jwtTokenUtil;
  private  final IAuthenticationUserService service;
  private final ConversionService conversionService;

    public AuthController(JwtTokenHandler jwtTokenUtil, IAuthenticationUserService service, ConversionService conversionService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.service = service;
        this.conversionService = conversionService;
    }

    @PostMapping("/registration")
   public ResponseEntity<?> create(@Valid @RequestBody UserRegistration userRegistration) {

      this.service.create(userRegistration);
      return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }

   @GetMapping(path = "/verification")
   public ResponseEntity<?> verifyCode(@RequestParam String code,
                                      @RequestParam String mail) {
      service.verify(code, mail);
      return ResponseEntity.status(HttpStatus.OK).build();
  }

//   @PostMapping(path = "/login")
//   public ResponseEntity<?> login(@RequestBody @Validated UserLogin user) {
//      UserJsonModel login = service.login(user);
//      return ResponseEntity.status(HttpStatus.OK)
//            .body(jwtTokenUtil.generateAccessToken(login));
//  }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Validated UserLogin user) {
        UserJsonModel login = conversionService.convert(service.login(user), UserJsonModel.class);
        if(login==null) {
            throw  new UserNotFoundExeption();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(jwtTokenUtil.generateAccessToken(login));
    }
   @GetMapping(path = "/me")
   public ResponseEntity<?> getUser() {
      UserHolder userHolder=new UserHolder();
      UUID uuid=userHolder.getUser().getUuid();
      return ResponseEntity.status(HttpStatus.OK).body(uuid);
   }
}
