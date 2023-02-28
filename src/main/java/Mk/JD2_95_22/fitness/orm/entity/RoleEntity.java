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

    public RoleEntity(String name) {
       this.name = name;
    }
    public String getName() {
        return name;
    }

}
