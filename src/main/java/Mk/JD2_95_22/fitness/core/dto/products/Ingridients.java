package Mk.JD2_95_22.fitness.core.dto.products;

import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.UUID;

public class Ingridients {
    @NonNull
    private ProductDTO product;
    @NonNull
    private UUID id;
    @NonNull
    private Integer weight;

    public Ingridients(@NonNull ProductDTO product, @NonNull UUID id, @NonNull Integer weight) {
        this.product = product;
        this.id = id;
        this.weight = weight;
    }

    @NonNull
    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(@NonNull ProductDTO product) {
        this.product = product;
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
}
