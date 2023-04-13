package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;

import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.web.utils.UserHolder;
import Mk.JD2_95_22.fitness.service.api.user.IAuthenticationService;
import Mk.JD2_95_22.fitness.web.utils.JwtTokenUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/api/v1/users")
public class AuthenticationController {
    private IAuthenticationService service;
    private UserHolder userHolder;
    private final JwtTokenUtil jwtTokenUtil;
    ConversionService conversionService;

    public AuthenticationController(IAuthenticationService service, UserHolder userHolder, JwtTokenUtil jwtTokenUtil) {
        this.service = service;
        this.userHolder = userHolder;
        this.jwtTokenUtil = jwtTokenUtil;
    }
//
//    @RequestMapping(path = "/registration", method = RequestMethod.POST)
//    public ResponseEntity<?> registration(@RequestBody @Valid UserRegistration userRegistration) {
//        service.registration(userRegistration);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @RequestMapping(path = "/verification", method = RequestMethod.GET)
//    public ResponseEntity<?> verification(@RequestParam("code") @NotBlank String code, @RequestParam("mail") @Email String mail) {
//        service.verification(code, mail);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @RequestMapping(path = "/login", method = RequestMethod.POST)
//    public String logIn(@RequestBody @Valid UserLogin userLogin) {
//       UserJsonModel userJsonModel = service.logIn(userLogin);
//        return jwtTokenUtil.generateAccessToken(userJsonModel);
//    }
//
//    @RequestMapping(path = "/me", method = RequestMethod.GET)
//    public ResponseEntity<UserJsonModel> get() {
//        return ResponseEntity.status(HttpStatus.OK).body(userHolder.getUser());
//    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> registration(@RequestBody @Valid UserRegistration user) {
        service.registration(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/verification", method = RequestMethod.GET)
    public ResponseEntity<?> verification(@RequestParam("code") @NotBlank String code, @RequestParam("mail") @Email String mail) {
        service.verification(code, mail);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> logIn(@RequestBody @Valid UserLogin user) {
        UserJsonModel userDTO = service.logIn(user);
        return ResponseEntity.status(HttpStatus.OK).body(jwtTokenUtil.generateAccessToken(userDTO));
    }

    @RequestMapping(path = "/me", method = RequestMethod.GET)
    public ResponseEntity<UserJsonModel> get() {
        UserHolder userHolder = new UserHolder();
        return ResponseEntity.status(HttpStatus.OK).body(userHolder.getUser());
    }

}
