package Mk.JD2_95_22.fitness.core.dto.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.lang.Double;
import java.util.Objects;

public class ProductCreated  {
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

    public ProductCreated(String title, Integer weight, Integer calories, Double proteins, Double fats, Double carbohydrates) {
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCreated that = (ProductCreated) o;
        return Objects.equals(title, that.title) && Objects.equals(weight, that.weight) && Objects.equals(calories, that.calories) && Objects.equals(proteins, that.proteins) && Objects.equals(fats, that.fats) && Objects.equals(carbohydrates, that.carbohydrates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, calories, proteins, fats, carbohydrates);
    }
}


