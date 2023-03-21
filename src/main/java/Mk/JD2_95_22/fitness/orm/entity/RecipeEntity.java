package Mk.JD2_95_22.fitness.orm.entity;

import Mk.JD2_95_22.fitness.core.converter.number.InstantConverterToLong;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "fitness", name = "recipe")
public class RecipeEntity {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @JsonSerialize(converter = InstantConverterToLong.Serializer.class)
    @Column(name = "dt_create")
    private Instant dtCreate;
    @JsonSerialize(converter = InstantConverterToLong.Serializer.class)
    @Version
    @Column(name = "dt_update")
    private Instant dtUpdate;
    @Column(name = "title")
    private String title;
    @ElementCollection
    @CollectionTable(
            schema = "fitness",
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_uuid")
    )
    private List<IngredientEntity> composition;


    public RecipeEntity() {
    }

    public RecipeEntity(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, List<IngredientEntity> composition) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.composition = composition;
    }


    public RecipeEntity(Instant dtCreate, Instant dtUpdate, String title, List<IngredientEntity> composition) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.composition = composition;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public List<IngredientEntity> getComposition() {
        return composition;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposition(List<IngredientEntity> composition) {
        this.composition = composition;
    }
}
