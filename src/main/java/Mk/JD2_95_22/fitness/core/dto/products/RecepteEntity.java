package Mk.JD2_95_22.fitness.core.dto.products;

import Mk.JD2_95_22.fitness.orm.entity.IngridientsEntity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="recepte", schema = "fitness")
public class RecepteEntity {

    @Id
    @Column(name = "id")
    @NonNull
    private UUID uuid;
    @Column(name="date_created")
    private Instant dtCreate;
    @Version
    @Column(name="date_last_update")
    private Instant dtUpdate;
    @Column(name="title")
    private String title;

    @ElementCollection
    @CollectionTable(schema = "fitnes",
                     name="recepte_ingridients",
    joinColumns = @JoinColumn(name="id"))
    private List<IngridientsEntity> composition;

    public RecepteEntity() {
    }

    public RecepteEntity(@NonNull UUID uuid, Instant dtCreate, Instant dtUpdate, String title, List<IngridientsEntity> composition) {
        this.uuid = UUID.randomUUID();
        this.dtCreate = Instant.now();
        this.dtUpdate = Instant.now();
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

    public Instant getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
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
