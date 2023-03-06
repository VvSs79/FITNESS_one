package Mk.JD2_95_22.fitness.orm.entity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "User", schema = "fitness")
public class UserEntity extends BaseEssenceEntety {
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

    public UserEntity() {
    }

    public UserEntity(@NonNull String mail, @NonNull String fio, @NonNull RoleEntity role, @NonNull StatusEntity status, @NonNull String password) {
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.password = password;
    }

    @NonNull
    public String getMail() {
        return mail;
    }

    public void setMail(@NonNull String mail) {
        this.mail = mail;
    }

    @NonNull
    public String getFio() {
        return fio;
    }

    public void setFio(@NonNull String fio) {
        this.fio = fio;
    }

    @NonNull
    public RoleEntity getRole() {
        return role;
    }

    public void setRole(@NonNull RoleEntity role) {
        this.role = role;
    }

    @NonNull
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(@NonNull StatusEntity status) {
        this.status = status;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
