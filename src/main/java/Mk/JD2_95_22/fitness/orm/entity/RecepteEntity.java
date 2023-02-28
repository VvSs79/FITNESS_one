package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.dto.products.Ingridients;
import Mk.JD2_95_22.fitness.orm.entity.IngridientsEntity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recepte")
public class RecepteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private UUID uuid;
    @Column(name = "data_created")
    private Instant dt_Created;
    @Column(name = "data_last_update")
    private Instant dt_Update;
    @Column(name="title")
    private String title;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="composition",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private List<IngridientsEntity> composition;

    public RecepteEntity() {
    }

    public RecepteEntity(@NonNull UUID uuid, Instant dt_Created, Instant dt_Update, String title, List<IngridientsEntity> composition) {
        this.uuid = uuid;
        this.dt_Created = dt_Created;
        this.dt_Update = dt_Update;
        this.title = title;
        this.composition = composition;
    }

    @NonNull
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getDt_Created() {
        return dt_Created;
    }

    public void setDt_Created(Instant dt_Created) {
        this.dt_Created = dt_Created;
    }

    public Instant getDt_Update() {
        return dt_Update;
    }

    public void setDt_Update(Instant dt_Update) {
        this.dt_Update = dt_Update;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngridientsEntity> getComposition() {
        return composition;
    }

    public void setComposition(List<IngridientsEntity> composition) {
        this.composition = composition;
    }
}
