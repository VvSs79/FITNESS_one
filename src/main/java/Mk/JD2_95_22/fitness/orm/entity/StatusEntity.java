package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.util.UserStatus;
import jakarta.persistence.*;

@Entity
@Table(name="user_status")

public class StatusEntity {
    @Id
    @Enumerated(EnumType.STRING)
    private String name;

    public StatusEntity() {
    }

    public StatusEntity(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }
}
