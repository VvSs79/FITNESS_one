package Mk.JD2_95_22.fitness.orm.entity.utils;

import Mk.JD2_95_22.fitness.core.util.MailStatus;
import jakarta.persistence.*;


@Entity
@Table(name ="mail_status")
public class MailStatusEntity {
    @Id
    @GeneratedValue(generator = "role_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mail_status_eq", sequenceName = "mail_status_id_seq",
            schema = "fitness", allocationSize = 1)
    private int id;
    @Enumerated(EnumType.STRING)
    private MailStatus mailStatus;

    public MailStatusEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MailStatusEntity(MailStatus mailStatus) {
        this.mailStatus = mailStatus;
        this.id = (short) (mailStatus.ordinal() + 1);
    }

    public MailStatus getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(MailStatus mailStatus) {
        this.mailStatus = mailStatus;
    }
}
