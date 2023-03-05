package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;


@Entity
@Table(name="user_status")
public class RoleEntity {
    @Id
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
