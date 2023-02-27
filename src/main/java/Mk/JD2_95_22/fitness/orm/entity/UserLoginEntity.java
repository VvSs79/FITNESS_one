package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Entity
@Table(name="UserLogin" )
public class UserLoginEntity {
    @Id
    @Column(name = "id")
    @NonNull
    private UUID id;
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

    @NonNull
    public UUID getId() {
        return id;
    }

    public void setId(@NonNull UUID id) {
        this.id = id;
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
