package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name ="mail_status")
public class MailStatusEntity {
    @Id
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
