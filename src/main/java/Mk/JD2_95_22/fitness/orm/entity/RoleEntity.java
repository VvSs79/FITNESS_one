package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import jakarta.persistence.*;


@Entity
@Table(schema = "fitness", name = "role")
public class RoleEntity {
    @Id
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public RoleEntity() {
    }

    public RoleEntity(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }
}

