package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.util.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Objects;


public class UserDTO implements Serializable {

    private BaseEssence  baseEssence;
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



    public UserDTO(BaseEssence baseEssence, String mail, String fio, UserRole role, UserStatus status) {
        this.baseEssence = baseEssence;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
    }

    public BaseEssence getBaseEssence() {
        return baseEssence;
    }

    public void setBaseEssence(BaseEssence baseEssence) {
        this.baseEssence = baseEssence;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(baseEssence, userDTO.baseEssence) && Objects.equals(mail, userDTO.mail) && Objects.equals(fio, userDTO.fio) && role == userDTO.role && status == userDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseEssence, mail, fio, role, status);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "baseEssence=" + baseEssence +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}

