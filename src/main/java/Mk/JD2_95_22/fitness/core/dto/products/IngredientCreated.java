package Mk.JD2_95_22.fitness.core.dto.products;

import org.springframework.lang.NonNull;

public class IngredientCreated {
    @NonNull
    private ProductDTO product;
    @NonNull
    private Integer weight;

    public IngredientCreated(@NonNull ProductDTO product, @NonNull Integer weight) {
        this.product = product;
        this.weight = weight;
    }

    public IngredientCreated() {
    }

    @NonNull
    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(@NonNull ProductDTO product) {
        this.product = product;
    }

    @NonNull
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(@NonNull Integer weight) {
        this.weight = weight;
    }
}
