package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.util.UserStatus;
import core.util.UserRole;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="user_status")

public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private String name;

    public StatusEntity() {
    }

    public StatusEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
