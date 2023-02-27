package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Entity
@Table(name ="mail_status")
public class MailStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;
    @NonNull
    @Column(name="name")
    private String name;

    public MailStatusEntity() {
    }

    public MailStatusEntity(String name) {
        this.name = name;
    }
}
