package Mk.JD2_95_22.fitness.orm.entity.utils;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name ="mail_status")
public class MailStatusEntity {
    @Id
    @GeneratedValue(generator = "role_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mail_status_eq", sequenceName = "mail_status_id_seq",
            schema = "fitness", allocationSize = 1)
    @Enumerated(EnumType.STRING)
    private String name;

    public MailStatusEntity() {
    }

    public MailStatusEntity(String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
