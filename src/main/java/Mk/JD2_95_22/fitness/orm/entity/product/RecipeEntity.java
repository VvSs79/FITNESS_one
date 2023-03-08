package Mk.JD2_95_22.fitness.orm.entity.product;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recepte", schema = "fitness",
        uniqueConstraints = {@UniqueConstraint(columnNames = "uuid"),
                             @UniqueConstraint(columnNames = "title")})
public class RecipeEntity  {
    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "dt_create")
    private Instant dtCreate;
    @Column(name = "dt_update")
    @Version
    private Instant dtUpdate;
    @Column(name = "title")
    private String title;

    @Column(name = "composition")
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="recipe_ingredient",
            joinColumns=
            @JoinColumn(name="recipe_UUID", referencedColumnName="UUID"),
            inverseJoinColumns=
            @JoinColumn(name="ingredient_ID", referencedColumnName="ID")
    )
    private List<IngridientsEntity> composition;

    public RecipeEntity() {
    }

    public RecipeEntity(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, List<IngridientsEntity> composition) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.composition = composition;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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
