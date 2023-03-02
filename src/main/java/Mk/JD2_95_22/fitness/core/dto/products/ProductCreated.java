package Mk.JD2_95_22.fitness.core.dto.products;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;

import java.util.Objects;

public class ProductCreated {
    private BaseEssence baseEssence;
    private String title;
    private double weight;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;


    public ProductCreated(BaseEssence baseEssence, String title, double weight, double calories, double proteins, double fats, double carbohydrates) {
        this.baseEssence = baseEssence;
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public BaseEssence getBaseEssence() {
        return baseEssence;
    }

    public void setBaseEssence(BaseEssence baseEssence) {
        this.baseEssence = baseEssence;
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
        ProductCreated that = (ProductCreated) o;
        return Double.compare(that.weight, weight) == 0 && Double.compare(that.calories, calories) == 0 && Double.compare(that.proteins, proteins) == 0 && Double.compare(that.fats, fats) == 0 && Double.compare(that.carbohydrates, carbohydrates) == 0 && Objects.equals(baseEssence, that.baseEssence) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseEssence, title, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "ProductCreated{" +
                "baseEssence=" + baseEssence +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
