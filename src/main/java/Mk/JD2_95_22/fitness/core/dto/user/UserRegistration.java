package Mk.JD2_95_22.fitness.core.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

public class UserRegistration {
    @NotBlank
    private String fio;
    @NotBlank
    @Email
    private String mailUser;
    @NotBlank
    private String password;

    public UserRegistration(String FIOuser, String mailUser, String password) {
        this.fio = FIOuser;
        this.mailUser = mailUser;
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistration that = (UserRegistration) o;
        return Objects.equals(fio, that.fio) && Objects.equals(mailUser, that.mailUser) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, mailUser, password);
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "FIOuser='" + fio + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
