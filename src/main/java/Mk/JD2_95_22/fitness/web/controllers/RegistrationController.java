package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;

import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.web.utils.UserHolder;
import Mk.JD2_95_22.fitness.service.api.user.IRegistrationService;
import Mk.JD2_95_22.fitness.web.utils.JwtTokenUtil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/api/v1/users")
public class RegistrationController {
    private IRegistrationService service;
    private UserHolder userHolder;
    private final JwtTokenUtil jwtTokenUtil;


    public RegistrationController(IRegistrationService service, UserHolder userHolder, JwtTokenUtil jwtTokenUtil) {
        this.service = service;
        this.userHolder = userHolder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody @Validated UserRegistration user) {
        service.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/verification", method = RequestMethod.GET)
    public ResponseEntity<?> verification(@RequestParam("code") @NotBlank String code,
                                          @RequestParam("mail") @Email String mail) {
        service.verification(code, mail);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Пользователь верифицирован");
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> logIn(@RequestBody @Validated UserLogin user) {
        UserJsonModel userDTO = service.logIn(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(jwtTokenUtil.generateToken(userDTO));
    }
    @RequestMapping(path = "/me", method = RequestMethod.GET)
    public ResponseEntity<?>  getUser() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userHolder.getUser());
    }
    @RequestMapping( path = "/details", method = RequestMethod.GET)
    protected ResponseEntity<?> verify(
            @RequestParam(name = "mail") @Email String mail)  {
        service.getUser(mail);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
