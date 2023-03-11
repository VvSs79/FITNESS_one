package Mk.JD2_95_22.fitness.orm.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="UserLogin" , schema = "fitness")
public class UserLoginEntity {
    @Id
    @Column(name="mailUser")
    private String mailUser;
    @Column(name="password")
    private String password;

    public UserLoginEntity() {
    }

    public UserLoginEntity(String mailUser, String password) {
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
}
