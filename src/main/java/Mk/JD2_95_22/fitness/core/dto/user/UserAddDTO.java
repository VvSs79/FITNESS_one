package Mk.JD2_95_22.fitness.core.dto.user;


import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;

import java.time.Instant;

public class UserAddDTO {

    private UserCreate userCreate;
    private Instant dtUpdate;
    private Instant dtCreate;
    private UserRegistration userRegistration;
    private UserRole role;
    private UserStatus status;

    public UserAddDTO(UserCreate userCreate) {
        this.userCreate = userCreate;
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

    public UserCreate getUserCreate() {
        return userCreate;
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

    public void setUserCreate(UserCreate userCreate) {
        this.userCreate = userCreate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setUserRegistration(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
