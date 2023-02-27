package Mk.JD2_95_22.fitness.core.dto.products;

import Mk.JD2_95_22.fitness.core.dto.BasicEssence.Essence;

import java.util.Objects;

public class Product {
    private Essence essence;
    private String title;
    private double weight;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public Product(Essence essence, String title, double weight, double calories, double proteins, double fats, double carbohydrates) {
        this.essence = essence;
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Essence getEssence() {
        return essence;
    }

    public void setEssence(Essence essence) {
        this.essence = essence;
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
        Product product = (Product) o;
        return Double.compare(product.weight, weight) == 0 && Double.compare(product.calories, calories) == 0 && Double.compare(product.proteins, proteins) == 0 && Double.compare(product.fats, fats) == 0 && Double.compare(product.carbohydrates, carbohydrates) == 0 && Objects.equals(essence, product.essence) && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(essence, title, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "Product{" +
                "essence=" + essence +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
