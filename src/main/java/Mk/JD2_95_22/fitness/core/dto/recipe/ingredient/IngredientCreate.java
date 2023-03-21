package Mk.JD2_95_22.fitness.core.dto.recipe.ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public class IngredientCreate {
    @NotBlank
    private UUID product;
    @PositiveOrZero
    private Integer weight;

    public IngredientCreate(UUID product, Integer weight) {
        this.product = product;
        this.weight = weight;
    }

    public IngredientCreate() {
    }

    public UUID getProduct() {
        return product;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setProduct(UUID product) {
        this.product = product;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
