package Mk.JD2_95_22.fitness.core.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductCreate {
    @NotBlank(message = "Must not be blank")
    private String title;
    @Positive(message = "Should be positive")

    private Integer weight;
    @PositiveOrZero(message = "Should be positive or zero")

    private Integer calories;
    @PositiveOrZero(message = "Should be positive or zero")

    private Double proteins;
    @PositiveOrZero(message = "Should be positive or zero")

    private Double fats;
    @PositiveOrZero(message = "Should be positive or zero")
    private Double carbohydrates;

    public ProductCreate(String title, Integer weight, Integer calories, double proteins, double fats, double carbohydrates) {
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public String getTitle() {
        return title;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getCalories() {
        return calories;
    }

    public Double getProteins() {
        return proteins;
    }

    public Double getFats() {
        return fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }
}
