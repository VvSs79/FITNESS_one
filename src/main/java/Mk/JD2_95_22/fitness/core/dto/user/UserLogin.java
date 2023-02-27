package Mk.JD2_95_22.fitness.core.dto.user;

import java.util.Objects;

public class UserLogin {
    private String mailUser;
    private String password;

    public UserLogin(String mailUser, String password) {
        this.mailUser = mailUser;
        this.password = password;
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
        UserLogin userLogin = (UserLogin) o;
        return Objects.equals(mailUser, userLogin.mailUser) && Objects.equals(password, userLogin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailUser, password);
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
