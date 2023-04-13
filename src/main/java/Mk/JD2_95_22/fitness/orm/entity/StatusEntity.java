package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

@Entity
@Table(schema = "fitness",name = "status")
public class StatusEntity {
    @Id
    @Positive(message = "ID must be positive!")
    @Column(name="id", updatable=false, nullable=false)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public StatusEntity() {
    }

    public StatusEntity(Integer id, UserStatus status) {
        this.id = (int)(status.ordinal()+1);
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity status1 = (StatusEntity) o;
        return id == status1.id && status == status1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}