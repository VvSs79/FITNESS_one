package Mk.JD2_95_22.fitness.orm.entity.product;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ingridients", schema = "fitness",
        uniqueConstraints = @UniqueConstraint(columnNames = "uuid"))
public class IngridientsEntity {
    @Id
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "dt_create")
    private Instant dtCreate;

    @Column(name = "dt_update")
    @Version
    private Instant dtUpdate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name = "id",
                 nullable = false, updatable = false
    )
    private ProductEntity product;
    @Column(name="weight")
    private Integer weight;

    public IngridientsEntity() {
    }

    public IngridientsEntity(ProductEntity product, Integer weight) {
        this.product = product;
        this.weight = weight;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
