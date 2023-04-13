package Mk.JD2_95_22.fitness.web.controllers;


import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.user.UserUpdate;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.web.utils.UserHolder;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final IUserService userService;
    private final UserHolder userHolder;

    public UserController(IUserService userService, UserHolder userHolder) {
        this.userService = userService;
        this.userHolder = userHolder;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody @Validated UserCreate users) {
        userService.create(users);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PageDTO> getPageUsers(@RequestParam(defaultValue = "0") @Min(0) int page,
                                                @RequestParam(defaultValue = "20") @Min(0) int size) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getPageUsers(page, size));
    }

    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<UserJsonModel> getUserUuid(@PathVariable("uuid") UUID userUUID) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUserUuid(userUUID));
}

    @RequestMapping(path = "/{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("uuid") UUID userUUID,
                                    @PathVariable("dt_update") Instant dtUpdate,
                                    @RequestBody @Validated UserCreate user) {
        userService.update(new UserUpdate(user, dtUpdate, userUUID));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
//
//    @RequestMapping(path = "/me", method = RequestMethod.GET)
//    public ResponseEntity<UserJsonModel> getUser() {
//        return ResponseEntity.status(HttpStatus.OK).body(userHolder.getUser());
//    }
//    @RequestMapping( path = "/details", method = RequestMethod.GET)
//    protected ResponseEntity<?> verify(
//            @RequestParam(name = "mail") String mail)  {
//        userService.getUser(mail);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
