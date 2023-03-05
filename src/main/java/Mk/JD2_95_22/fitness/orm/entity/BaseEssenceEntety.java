package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;
@Entity
@Table(name="base_essence")
public class BaseEssenceEntety {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private UUID uuid;
    @Column(name="dt_create")
    private Instant timeCreated;
    @Version
    @Column(name="dt_update")
    private Instant dt_update;

    public BaseEssenceEntety() {
    }

    public BaseEssenceEntety(UUID uuid, Instant timeCreated, Instant dt_update) {
        this.uuid = uuid;
        this.timeCreated = timeCreated;
        this.dt_update = dt_update;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Instant timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Instant getDt_update() {
        return dt_update;
    }

    public void setDt_update(Instant dt_update) {
        this.dt_update = dt_update;
    }
}
