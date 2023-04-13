package Mk.JD2_95_22.fitness.orm.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(schema = "fitness", name = "users")
public class UserEntity {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(name = "mail")
    @Email
    @NotNull
    private String mail;
    @Column(name = "fio")
    @NotNull
    private String fio;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "dt_create")
    @NotNull
    private Instant dtCreate;
    @Column(name = "dt_update")
    @Version
    private Instant dtUpdate;
    @Enumerated(EnumType.STRING)
    @ManyToOne()
    @JoinColumn(name = "role")
    private RoleEntity role;
    @Enumerated(EnumType.STRING)
    @ManyToOne()
    @JoinColumn(name = "status")
    private StatusEntity status;
    @Column(name = "code")
//    @NotNull
    private String code;

    public UserEntity() {
    }

    public UserEntity( String mail, String fio, String password, Instant dtCreate, Instant dtUpdate, RoleEntity role, StatusEntity status) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.role = role;
        this.status = status;
    }

    public UserEntity(String mail, String fio, String password, Instant dtCreate, Instant dtUpdate, RoleEntity role, StatusEntity status, String code) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.role = role;
        this.status = status;
        this.code = code;
    }

    public UserEntity(UUID uuid, String mail, String fio, String password, Instant dtCreate, Instant dtUpdate, RoleEntity role, StatusEntity status, String code) {
        this.uuid = uuid;
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.role = role;
        this.status = status;
        this.code = code;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getMail() {
        return mail;
    }

    public String getFio() {
        return fio;
    }

    public String getPassword() {
        return password;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public RoleEntity getRole() {
        return role;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}