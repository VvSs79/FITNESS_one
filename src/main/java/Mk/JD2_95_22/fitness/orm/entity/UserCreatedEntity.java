package Mk.JD2_95_22.fitness.orm.entity;

import core.util.UserRole;
import core.util.UserStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Entity
@Table(name = "UserCreated", schema = "app")
public class UserCreatedEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private UUID uuid;
    @Column(name = "FIO")
    private String FIOuser;
    @Column(name = "mail")
    private String mailUser;
    @Column(name = "password")
    private String password;
    @Column(name = "userRole")
    private UserRole userRole;
    @Column(name = "userStatus")
    private UserStatus userStatus;

    public UserCreatedEntity() {
    }

    public UserCreatedEntity(String FIOuser, String mailUser, String password, UserRole userRole, UserStatus userStatus) {
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
    public String toString() {
        return "UserCreatedEntity{" +
                "uuid=" + uuid +
                ", FIOuser='" + FIOuser + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", userStatus=" + userStatus +
                '}';
    }
}
