package Mk.JD2_95_22.fitness.orm.entity.utils;

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
