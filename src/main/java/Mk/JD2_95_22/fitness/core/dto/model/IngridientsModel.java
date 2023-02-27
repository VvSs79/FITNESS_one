package Mk.JD2_95_22.fitness.core.dto.model;

import Mk.JD2_95_22.fitness.converter.DoubleConvert;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.criteria.CriteriaBuilder;

public class IngridientsModel {
    @JsonProperty("product")
    private ProductModel product;

    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("calories")
    private Integer calories;
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

    public IngridientsModel(ProductModel product, Integer weight, Integer calories, Double proteins, Double fats, Double carbohydrates) {
        this.product = product;
        this.weight = weight;
        this.calories = countInt(product.getCalories());
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
    private Integer countInt(Integer value){
        return weight*value/product.getWeight();
    }
    private Double counDoubl(Double value){
        return weight*value/product.getWeight();
    }
}
