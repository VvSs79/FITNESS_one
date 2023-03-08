package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.MailStatusEntity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="MailUser")
public class MailEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;
    @Column(name="MailOfSender")
    private String emailFrom;
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="user",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private UserEntity emailTo;
    @Column(name="Subject")
    private String subject;
    @Column(columnDefinition = "TEXT")
    private UUID text;
    @Column(columnDefinition = "DateAndTimeSendMail")
    private LocalDateTime sendDateEmail;
    @NonNull
    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="mail_status",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private MailStatusEntity statusMail;

    public MailEntity() {
    }

    public MailEntity(String emailFrom, UserEntity emailTo, String subject, UUID text, LocalDateTime sendDateEmail, MailStatusEntity statusMail) {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusMail = statusMail;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getText() {
        return text;
    }

    public void setText(UUID text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    @NonNull
    public MailStatusEntity getStatusMail() {
        return statusMail;
    }

    public void setStatusMail(@NonNull MailStatusEntity statusMail) {
        this.statusMail = statusMail;
    }
}
