package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import Mk.JD2_95_22.fitness.service.validate.api.ValidPassword;
import Mk.JD2_95_22.fitness.service.validate.api.ValidString;
//import Mk.JD2_95_22.fitness.service.validate.validator_enum.ValueOfEnum;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class UserCreate {
    @ValidMail
    @ValidString
    private String mail;
    @ValidString
    private String fio;
    @ValidPassword
    @ValidString
    private String password;
//    @ValueOfEnum(enumClass = UserRole.class)
    @NotNull(message = "The entered value doesn't exist")
    private String role;
//    @ValueOfEnum(enumClass = UserStatus.class)
    @NotNull(message = "The entered value doesn't exist")
    private String status;

    public UserCreate(String mail, String fio, String password, String role, String status) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public UserCreate(String mail, String fio, String password) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.role = UserRole.USER.toString();
        this.status = UserStatus.WAITING_ACTIVATION.toString();
    }

    public UserCreate() {
    }

    public String getMail() {
        return mail;
    }

    public String getFio() {
        return fio;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return UserRole.valueOf(role);
    }

    public UserStatus getStatus() {
        return UserStatus.valueOf(status);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreate userDTO = (UserCreate) o;
        return Objects.equals(mail, userDTO.mail) && Objects.equals(fio, userDTO.fio) && Objects.equals(password, userDTO.password) && role == userDTO.role && status == userDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, fio, password, role, status);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}

