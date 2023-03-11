package Mk.JD2_95_22.fitness.orm.entity.product;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Embeddable
public class IngridientsEntity {
    @ManyToOne
    @JoinColumn (name = "product_id",
            nullable = false, updatable = false)


    private ProductEntity product;
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
