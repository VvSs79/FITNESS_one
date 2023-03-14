package Mk.JD2_95_22.fitness.orm.entity.user;

import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "Users", schema = "fitness")
public class UserEntity {
    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "dt_create")
    private Instant dtCreate;
    @Version
    @Column(name = "dt_update")
    private Instant dtUpdate;
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
    inverseJoinColumns = @JoinColumn(name="id"))
    private RoleEntity role;

    @NonNull
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user_status",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="id"))
    private StatusEntity status;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "code", table= "verification")
    private String code;

    public UserEntity() {
    }

    public UserEntity(UUID uuid, Instant dtCreate, Instant dtUpdate, @NonNull String mail, @NonNull String fio, @NonNull RoleEntity role, @NonNull StatusEntity status, @NonNull String password, String code) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.password = password;
        this.code = code;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
