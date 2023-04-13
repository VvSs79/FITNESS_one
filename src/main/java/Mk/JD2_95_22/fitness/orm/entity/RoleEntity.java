package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.Objects;


@Entity
@Table(schema = "fitness", name = "role")
public class RoleEntity {
    @Id
    @Positive(message = "ID must be positive!")
    @Column(name="id", updatable=false, nullable=false)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public RoleEntity() {
    }

    public RoleEntity(Integer id, UserRole role) {
        this.id =(int) (role.ordinal()+1);
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}

