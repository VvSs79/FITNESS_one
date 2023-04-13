package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import Mk.JD2_95_22.fitness.service.validate.api.ValidPassword;
import Mk.JD2_95_22.fitness.service.validate.api.ValidString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class UserLogin {
    @ValidMail
    @ValidString
    private String mail;
    @ValidPassword
    @ValidString
    private String password;

    public UserLogin(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public UserLogin() {
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLogin that = (UserLogin) o;
        return Objects.equals(mail, that.mail) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, password);
    }

    @Override
    public String toString() {
        return "UserLogInDTO{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
