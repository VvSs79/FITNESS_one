package Mk.JD2_95_22.fitness.core.dto.j_model;

import Mk.JD2_95_22.fitness.core.converter.number.DoubleConverterToBigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class IngredientJsonModel {

    @JsonProperty("product")
    private ProductJsonModel product;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("calories")
    private Integer calories;
    @JsonProperty("proteins")
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    private Double proteins;
    @JsonProperty("fats")
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    private Double fats;
    @JsonProperty("carbohydrates")
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    private Double carbohydrates;

    public IngredientJsonModel() {
    }

    public IngredientJsonModel(ProductJsonModel product, Integer weight, Integer calories, Double proteins, Double fats, Double carbohydrates) {
        this.product = product;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public ProductJsonModel getProduct() {
        return product;
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
