package Mk.JD2_95_22.fitness.core.dto.model;

import Mk.JD2_95_22.fitness.converter.number_format.DoubleConverterToBigDecimal;
import Mk.JD2_95_22.fitness.converter.number_format.InstantConvertorToLong;
import Mk.JD2_95_22.fitness.converter.number_format.StringConverterToInstant;
import Mk.JD2_95_22.fitness.converter.number_format.LongConverterToInstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class RecipeJsonModel {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonSerialize(converter = InstantConvertorToLong.class)
    @JsonProperty("dt_create")
    private Instant dt_create;
    @JsonSerialize(converter = InstantConvertorToLong.class)
    @JsonProperty("dt_update")
    private Instant dt_update;
    @JsonProperty("title")
    private String title;
    @JsonProperty("composition")
    private List<IngridientsJsonModel> composition;

    @JsonProperty("weight")
    private  Integer weight;
    @JsonProperty("calories")
    private  Integer calories;
    @JsonSerialize(converter = DoubleConverterToBigDecimal.class)
    @JsonProperty("proteins")
    private Double proteins;
    @JsonSerialize(converter =  DoubleConverterToBigDecimal.class)
    @JsonProperty("fats")
    private Double fats;
    @JsonSerialize(converter =  DoubleConverterToBigDecimal.class)
    @JsonProperty("carbohydrates")
    private Double carbohydrates;

    public RecipeJsonModel() {
    }

    public RecipeJsonModel(UUID uuid, Instant dt_create, Instant dt_update, String title, List<IngridientsJsonModel> composition, Integer weight, Integer calories, Double proteins, Double fats, Double carbohydrates) {
        this.uuid = uuid;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.title = title;
        this.composition = composition;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getDt_create() {
        return dt_create;
    }

    public void setDt_create(Instant dt_create) {
        this.dt_create = dt_create;
    }

    public Instant getDt_update() {
        return dt_update;
    }

    public void setDt_update(Instant dt_update) {
        this.dt_update = dt_update;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngridientsJsonModel> getComposition() {
        return composition;
    }

    public void setComposition(List<IngridientsJsonModel> composition) {
        this.composition = composition;
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
}