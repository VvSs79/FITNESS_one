package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import Mk.JD2_95_22.fitness.service.validate.api.ValidPassword;
import Mk.JD2_95_22.fitness.service.validate.api.ValidString;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class UserRegistration {
    @ValidMail
    @ValidString
    private String mail;
    @ValidString
    private String fio;
    @ValidPassword
    @ValidString
    private String password;

    public UserRegistration(String mail, String fio, String password) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
    }

    public UserRegistration() {
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistration that = (UserRegistration) o;
        return Objects.equals(mail, that.mail) && Objects.equals(fio, that.fio) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, fio, password);
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
