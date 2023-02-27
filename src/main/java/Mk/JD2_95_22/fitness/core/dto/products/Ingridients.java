package Mk.JD2_95_22.fitness.core.dto.products;

import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.UUID;

public class Ingridients {
    @NonNull
    private Product product;
    @NonNull
    private UUID id;
    @NonNull
    private Integer weight;

    public Ingridients(@NonNull Product product) {
        this.product = product;
    }

    public Ingridients(Integer weight, UUID id) {
        this.id = product.getEssence().getUuid();
        this.weight = weight;
    }

    @NonNull
    public UUID getId() {
        return id;
    }

    public void setId(@NonNull UUID id) {
        this.id = id;
    }

    @NonNull
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(@NonNull Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingridients that = (Ingridients) o;
        return id.equals(that.id) && weight.equals(that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight);
    }

    @Override
    public String toString() {
        return "Ingridients{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
