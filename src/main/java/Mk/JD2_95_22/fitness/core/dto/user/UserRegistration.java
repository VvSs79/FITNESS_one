package Mk.JD2_95_22.fitness.core.dto.user;

import java.util.Objects;

public class UserRegistration {

    private String FIOuser;
    private String mailUser;
    private String password;

    public UserRegistration(String FIOuser, String mailUser, String password) {
        this.FIOuser = FIOuser;
        this.mailUser = mailUser;
        this.password = password;
    }

    public String getFIOuser() {
        return FIOuser;
    }

    public void setFIOuser(String FIOuser) {
        this.FIOuser = FIOuser;
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
        return Objects.equals(FIOuser, that.FIOuser) && Objects.equals(mailUser, that.mailUser) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIOuser, mailUser, password);
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "FIOuser='" + FIOuser + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
