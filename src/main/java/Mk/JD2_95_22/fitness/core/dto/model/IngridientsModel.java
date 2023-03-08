package Mk.JD2_95_22.fitness.core.dto.model;

import Mk.JD2_95_22.fitness.converter.number_format.DoubleConvert;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class IngridientsModel {
    @JsonProperty("product")
    private ProductModel product;

    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("calories")
    private Double calories;
    @JsonSerialize(converter = DoubleConvert.Serializer.class)
    @JsonProperty("proteins")
    private Double proteins;
    @JsonSerialize(converter = DoubleConvert.Serializer.class)
    @JsonProperty("fats")
    private Double fats;
    @JsonSerialize(converter = DoubleConvert.Serializer.class)
    @JsonProperty("carbohydrates")
    private Double carbohydrates;

    public IngridientsModel() {
    }

    public IngridientsModel(ProductModel product, Double weight, Double calories, Double proteins, Double fats, Double carbohydrates) {
        this.product = product;
        this.weight = weight;
        this.calories = counDoubl(product.getCalories());
        this.proteins = counDoubl(product.getProteins());
        this.fats = counDoubl(product.getFats());
        this.carbohydrates = counDoubl(product.getCarbohydrates());
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
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
    private Double counDoubl(Integer value){
        return weight*value/product.getWeight();
    }
    private Double counDoubl(Double value){
        return weight*value/product.getWeight();
    }
}
