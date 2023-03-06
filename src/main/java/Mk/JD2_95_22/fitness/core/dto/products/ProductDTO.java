package Mk.JD2_95_22.fitness.core.dto.products;



import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
public class ProductDTO extends BaseEssence {
    @NotBlank(message = "Title must not be blank")
    private String title;
    @NotBlank(message = "Weight should not be less than 1")
    @Min(value = 1)
    private double weight;
    @NotBlank(message = "Calories should not be less than 1 ")
    @Min(value = 1)
    private double calories;
    @NotBlank(message = "Proteins should not be less than 1 ")
    @Min(value = 0)
    private double proteins;
    @NotBlank(message = "Fats should not be less than 0 ")
    @Min(value = 0)
    private double fats;
    @NotBlank(message = "Carbohydrates should not be less than 10")
    @Min(value = 0)
    private double carbohydrates;


    public ProductDTO(String title, double weight, double calories, double proteins, double fats, double carbohydrates) {
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

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
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
        ProductDTO that = (ProductDTO) o;
        return Double.compare(that.weight, weight) == 0 && Double.compare(that.calories, calories) == 0 && Double.compare(that.proteins, proteins) == 0 && Double.compare(that.fats, fats) == 0 && Double.compare(that.carbohydrates, carbohydrates) == 0 && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "title='" + title + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
