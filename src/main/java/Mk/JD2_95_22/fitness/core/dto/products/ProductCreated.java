package Mk.JD2_95_22.fitness.core.dto.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Objects;

public class ProductCreated  {
    @NotBlank(message = "Must not be blank")
    private String title;
    @Positive(message = "Should be positive")
    private Integer weight;
    @PositiveOrZero(message = "Should be positive or zero")
    private Integer calories;
    @PositiveOrZero(message = "Should be positive or zero")
    private double proteins;
    @PositiveOrZero(message = "Should be positive or zero")
    private double fats;
    @PositiveOrZero(message = "Should be positive or zero")
    private double carbohydrates;

    public ProductCreated(String title, Integer weight, Integer calories, double proteins, double fats, double carbohydrates) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCreated that = (ProductCreated) o;
        return Double.compare(that.proteins, proteins) == 0 && Double.compare(that.fats, fats) == 0 && Double.compare(that.carbohydrates, carbohydrates) == 0 && Objects.equals(title, that.title) && Objects.equals(weight, that.weight) && Objects.equals(calories, that.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, calories, proteins, fats, carbohydrates);
    }
}
