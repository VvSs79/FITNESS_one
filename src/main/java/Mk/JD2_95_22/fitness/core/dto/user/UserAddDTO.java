package Mk.JD2_95_22.fitness.core.dto.user;


import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;

import java.time.Instant;

public class UserAddDTO {

    private UserCreate userDTO;
    private Instant dtUpdate;
    private Instant dtCreate;
    private UserRegistration userRegistration;
    private UserRole role;
    private UserStatus status;

    public UserAddDTO(UserCreate userDTO) {
        this.userDTO = userDTO;
        this.dtCreate = Instant.now();
        this.dtUpdate = this.dtCreate;
    }

    public UserAddDTO(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
        this.dtCreate = Instant.now();
        this.dtUpdate = this.dtCreate;
        this.role = UserRole.USER;
        this.status = UserStatus.WAITING_ACTIVATION;
    }

    public UserCreate getUserDTO() {
        return userDTO;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public UserRegistration getUserRegistrationDTO() {
        return userRegistration;
    }

    public UserRole getRole() {
        return role;
    }

    public UserStatus getStatus() {
        return status;
    }
}
