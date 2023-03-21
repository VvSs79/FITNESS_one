package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import jakarta.persistence.*;

@Entity
@Table(schema = "fitness",name = "status")
public class StatusEntity {
    @Id
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public StatusEntity() {
    }

    public StatusEntity(UserStatus status) {
        this.status = status;
    }


    public UserStatus getStatus() {
        return status;
    }
}