package Mk.JD2_95_22.fitness.orm.entity.user;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "User", schema = "fitness")
public class UserEntity {
    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "dt_create")
    private Instant dtCreate;

    @Column(name = "dt_update")
    @Version
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
    inverseJoinColumns = @JoinColumn(name="name"))
    private RoleEntity role;

    @NonNull
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user_status",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private StatusEntity status;
    private Boolean enabled;
    @Column(name = "password")
    @NonNull
    private String password;

    public UserEntity() {
    }

    public UserEntity(UUID uuid, Instant dtCreate, Instant dtUpdate, @NonNull String mail, @NonNull String fio, @NonNull RoleEntity role, @NonNull StatusEntity status, Boolean enabled, @NonNull String password) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.enabled = enabled;
        this.password = password;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
