package Mk.JD2_95_22.fitness.orm.entity.user;

import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
@Entity
@Table(name = "Users", schema = "fitness")
@SecondaryTable(name="verification", schema = "fitness",
        pkJoinColumns = @PrimaryKeyJoinColumn(name="uuid"))
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
    private String mail;
    @ Column(name = "fio") 
    private String fio;
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user_role",
    joinColumns = @JoinColumn(name="user_uuid"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private RoleEntity role;
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user_status",
            joinColumns = @JoinColumn(name="user_uuid"),
            inverseJoinColumns = @JoinColumn(name="status_id"))
    private StatusEntity status;
    @Column(name = "code", table= "verification")
    private String code;
    private String password;
    public UserEntity() {
    }
    public UserEntity(UUID uuid, Instant dtCreate, Instant dtUpdate,String mail, String fio, RoleEntity role,StatusEntity status, String password,String code) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.password = password;
        this.code=code;
    }

    public UserEntity(UUID uuid, Instant dtCreate, Instant dtUpdate,String mail, String fio, RoleEntity role,StatusEntity status, String password) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
        this.password = password;
    }
    public UserEntity(String mail, String fio, RoleEntity role,StatusEntity status, String password) {
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
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
    public void setStatus( StatusEntity status) {
        this.status = status;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword( String password) {
        this.password = password;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
