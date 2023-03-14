package Mk.JD2_95_22.fitness.orm.entity.utils;

import Mk.JD2_95_22.fitness.core.util.UserStatus;
import jakarta.persistence.*;

@Entity
@Table(name="user_status")

public class StatusEntity {
    @Id
    @GeneratedValue(generator = "status_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "status_seq", sequenceName = "user_status_id_seq",
            schema = "fitness", allocationSize = 1)
    private  int id;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public StatusEntity() {
    }

    public StatusEntity(UserStatus status) {
        this.status = status;
        this.id = (short) (status.ordinal() + 1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
