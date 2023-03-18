package Mk.JD2_95_22.fitness.core.dto.model;

import java.math.BigDecimal;
import Mk.JD2_95_22.fitness.converter.number_format.DoubleConverterToBigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class IngridientsJsonModel {
    @JsonProperty("product")
    private ProductJsonModel product;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("calories")
    private Integer calories;
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    @JsonProperty("proteins")
    private BigDecimal proteins;
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    @JsonProperty("fats")
    private BigDecimal fats;
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    @JsonProperty("carbohydrates")
    private BigDecimal carbohydrates;

    public IngridientsJsonModel() {
    }

    public IngridientsJsonModel(ProductJsonModel product, Integer weight, Integer calories, BigDecimal proteins, BigDecimal fats, BigDecimal carbohydrates) {
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

    public void setProduct(ProductJsonModel product) {
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
    private Integer countInteger(Integer value){
        return weight*value/product.getWeight();
    }

}
