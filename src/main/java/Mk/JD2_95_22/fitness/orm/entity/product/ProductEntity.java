package Mk.JD2_95_22.fitness.orm.entity.product;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table( name="product", schema = "fitness",
        uniqueConstraints = {@UniqueConstraint(columnNames = "uuid"),
                             @UniqueConstraint(columnNames = "title")})
public class ProductEntity {
    @Id
    @GeneratedValue
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
    private Integer weight;
    @Column(name = "calories")
    private Integer calories;
    @Column(name = "proteins")
    private BigDecimal proteins;
    @Column(name = "fats")
    private BigDecimal fats;
    @Column(name = "carbohydrates")
    private BigDecimal carbohydrates;

    public ProductEntity() {
    }

    public ProductEntity(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, Integer weight, Integer calories, BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public void setProteins(BigDecimal proteins) {
        this.proteins = proteins;
    }

    public BigDecimal getFats() {
        return fats;
    }

    public void setFats(BigDecimal fats) {
        this.fats = fats;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
