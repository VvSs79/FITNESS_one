package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="user_status")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private UUID id;
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private String name;
    public RoleEntity() {
    }

    public RoleEntity(UUID id, String name) {
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
