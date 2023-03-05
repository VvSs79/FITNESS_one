package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import core.util.UserRole;

import java.util.Objects;


public class UserCreated extends BaseEssence{
    private String FIOuser;
    private String mailUser;
    private String password;
    private UserRole userRole;
    private UserStatus userStatus;

    public UserCreated(String FIOuser, String mailUser, String password, UserRole userRole, UserStatus userStatus) {
        this.FIOuser = FIOuser;
        this.mailUser = mailUser;
        this.password = password;
        this.userRole = userRole;
        this.userStatus = userStatus;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreated that = (UserCreated) o;
        return Objects.equals(FIOuser, that.FIOuser) && Objects.equals(mailUser, that.mailUser) && Objects.equals(password, that.password) && userRole == that.userRole && userStatus == that.userStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIOuser, mailUser, password, userRole, userStatus);
    }

    @Override
    public String toString() {
        return "UserCreated{" +
                "FIOuser='" + FIOuser + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", userStatus=" + userStatus +
                '}';
    }
}
