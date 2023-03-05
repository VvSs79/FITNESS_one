package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import Mk.JD2_95_22.fitness.core.util.UserStatus;

import core.util.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;



public class UserDTO extends BaseEssence {

    @NotBlank(message = "email cannot be empty")
    private String mail;
    @NotBlank(message = "fio cannot be empty")
    private String fio;
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserRole role;
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserStatus status;

    public UserDTO(String mail, String fio, @NonNull UserRole role, @NonNull UserStatus status) {
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @NonNull
    public UserRole getRole() {
        return role;
    }

    public void setRole(@NonNull UserRole role) {
        this.role = role;
    }

    @NonNull
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(@NonNull UserStatus status) {
        this.status = status;
    }
}

