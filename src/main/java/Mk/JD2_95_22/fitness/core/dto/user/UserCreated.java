package Mk.JD2_95_22.fitness.core.dto.user;

import core.util.UserRole;
import core.util.UserStatus;

import java.util.UUID;

public class UserCreated {
    private UUID uuidUser;
    private String FIOuser;
    private String mailUser;
    private String password;
    private UserRole userRole;
    private UserStatus userStatus;

    public UserCreated(UUID uuidUser, String FIOuser, String mailUser, String password, UserRole userRole, UserStatus userStatus) {
        this.uuidUser = uuidUser;
        this.FIOuser = FIOuser;
        this.mailUser = mailUser;
        this.password = password;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public UUID getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(UUID uuidUser) {
        this.uuidUser = uuidUser;
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
        userRole = userRole;
    }

    public core.util.UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(core.util.UserStatus userStatus) {
        userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "UserCreated{" +
                "uuidUser=" + uuidUser +
                ", FIOuser='" + FIOuser + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                ", UserRole=" + userRole +
                ", UserStatus=" + userStatus +
                '}';
    }
}
