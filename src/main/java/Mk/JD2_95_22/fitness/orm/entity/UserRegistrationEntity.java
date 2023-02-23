package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "UserRegistration", schema = "app")
public class UserRegistrationEntity implements Serializable {
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

    public UserRegistrationEntity() {
    }
    public UserRegistrationEntity(String FIOuser, String mailUser, String password) {
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
    public String toString() {
        return "UserRegistrationEntity{" +
                "uuid=" + uuid +
                ", FIOuser='" + FIOuser + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
