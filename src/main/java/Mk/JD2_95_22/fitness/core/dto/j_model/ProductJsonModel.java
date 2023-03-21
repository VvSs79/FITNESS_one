package Mk.JD2_95_22.fitness.core.dto.j_model;


import Mk.JD2_95_22.fitness.core.converter.number.DoubleConverterToBigDecimal;
import Mk.JD2_95_22.fitness.core.converter.number.InstantConverterToLong;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;
import java.util.UUID;

public class ProductJsonModel {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonSerialize(converter = InstantConverterToLong.Serializer.class)
    @JsonProperty("dtCreate")
    private Instant dtCreate;
    @JsonSerialize(converter = InstantConverterToLong.Serializer.class)
    @JsonProperty("dtUpdate")
    private Instant dtUpdate;
    @JsonProperty("title")
    private String title;
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

    public ProductJsonModel() {
    }

    public ProductJsonModel(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, Integer weight, Integer calories, Double proteins, Double fats, Double carbohydrates) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
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
