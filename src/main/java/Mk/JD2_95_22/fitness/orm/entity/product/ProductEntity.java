package Mk.JD2_95_22.fitness.orm.entity.product;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table( name="product", schema = "fitness",
        uniqueConstraints = {@UniqueConstraint(columnNames = "uuid"),
                             @UniqueConstraint(columnNames = "title")})
public class ProductEntity {
    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "dt_create")
    private Instant dtCreate;
    @Version
    @Column(name = "dt_update")
    private Instant dtUpdate;
    @Column(name = "title")
    private String title;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "calories")
    private Double calories;
    @Column(name = "proteins")
    private Double proteins;
    @Column(name = "fats")
    private Double fats;
    @Column(name = "carbohydrates")
    private Double carbohydrates;

    public ProductEntity() {
    }

    public ProductEntity(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, Double weight, Double calories, Double proteins, Double fats, Double carbohydrates) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
