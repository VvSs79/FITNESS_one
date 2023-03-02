package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "User", schema = "fitness")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "id")
    @NonNull
    private BaseEssence baseEssence;
    @ Column(name = "mail")
    @NonNull
    private String mail;
    @ Column(name = "fio")
    @NonNull
    private String fio;
    @NonNull
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user_role",
    joinColumns = @JoinColumn(name="id"),
    inverseJoinColumns = @JoinColumn(name="name"))
    private RoleEntity role;

    @NonNull
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user_status",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private StatusEntity status;
    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "validation")
    private boolean isEnabled;


    public UserEntity(String mail,String fio,RoleEntity role,StatusEntity status,String password, boolean isEnabled) {

        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    @NonNull
    public BaseEssence getBaseEssence() {
        return baseEssence;
    }

    public void setBaseEssence(@NonNull BaseEssence baseEssence) {
        this.baseEssence = baseEssence;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean accountVerified) {
        this.isEnabled = accountVerified;
    }
}
