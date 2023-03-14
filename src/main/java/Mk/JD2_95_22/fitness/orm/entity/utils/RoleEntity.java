package Mk.JD2_95_22.fitness.orm.entity.utils;

import Mk.JD2_95_22.fitness.core.util.UserRole;
import jakarta.persistence.*;


@Entity
@Table(name="user_status")
public class RoleEntity {
    @Id
    @GeneratedValue(generator = "role_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "status_seq", sequenceName = "user_status_id_seq",
            schema = "fitness", allocationSize = 1)
    private int id;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    public RoleEntity() {
    }

    public RoleEntity(UserRole role) {
       this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.role = role;
        this.id = (short) (role.ordinal() + 1);
    }


    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
