package Mk.JD2_95_22.fitness.core.dto.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductCreated  {
    @NotBlank(message = "Must not be blank")
    private String title;
    @Positive(message = "Should be positive")
    private Integer weight;
    @PositiveOrZero(message = "Should be positive or zero")
    private Integer calories;
    @PositiveOrZero(message = "Should be positive or zero")
    private BigDecimal proteins;
    @PositiveOrZero(message = "Should be positive or zero")
    private BigDecimal fats;
    @PositiveOrZero(message = "Should be positive or zero")
    private BigDecimal carbohydrates;

    public ProductCreated(String title, Integer weight, Integer calories, BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
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


