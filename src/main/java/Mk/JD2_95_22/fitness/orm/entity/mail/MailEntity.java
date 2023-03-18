package Mk.JD2_95_22.fitness.orm.entity.mail;


import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="MailUser", schema = "fitness")
public class MailEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;
    @Column(name = "dt_create")
    @CreationTimestamp
    private Instant dtCreate;
    @Version
    @Column(name = "dt_update")
    private Instant dtUpdate;
    @Column(name="MailOfSender")
    private String emailFrom;
    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="mail",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private UserEntity emailTo;
    @Column(name="Subject")
    private String subject;
    @Column(name="code_verification")
    @Max(60)
    private UUID verification;
    public MailEntity() {
    }

    public MailEntity(UUID id, Instant dtCreate, Instant dtUpdate, String emailFrom, @NonNull UserEntity emailTo, String subject, UUID verification) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.verification = verification;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    @NonNull
    public UserEntity getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(@NonNull UserEntity emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public UUID getVerification() {
        return verification;
    }

    public void setVerification(UUID verification) {
        this.verification = verification;
    }
}
