package Mk.JD2_95_22.fitness.orm.entity.mail;

import Mk.JD2_95_22.fitness.core.util.MailStatus;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.MailStatusEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
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

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MailStatus status;

    public MailEntity() {
    }


}
