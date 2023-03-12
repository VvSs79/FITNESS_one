package Mk.JD2_95_22.fitness.core.dto.model;

import Mk.JD2_95_22.fitness.converter.number_format.BigDecimalConverter;
import Mk.JD2_95_22.fitness.converter.number_format.DoubleConverter;
import Mk.JD2_95_22.fitness.converter.number_format.InstantConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.Instant;
import java.util.UUID;
@JsonIgnoreProperties
public class ProductModel {
        @JsonProperty("uuid")
        private UUID uuid;
        @JsonSerialize(converter = InstantConverter.Serializer.class)
        @JsonProperty("dt_create")
        private Instant dtCreate;
        @JsonSerialize(converter = InstantConverter.Serializer.class)
        @JsonProperty("dt_update")
        private Instant dtUpdate;
        @JsonProperty("title")
        private String title;
        @JsonProperty("weight")
        private Integer weight;
        @JsonSerialize(converter = DoubleConverter.Serializer.class)
        @JsonProperty("calories")
        private Integer calories;
        @JsonSerialize(converter = DoubleConverter.Serializer.class)
        @JsonProperty("proteins")
        private Double proteins;
        @JsonSerialize(converter = DoubleConverter.Serializer.class)
        @JsonProperty("fats")
        private Double fats;
        @JsonSerialize(converter = DoubleConverter.Serializer.class)
        @JsonProperty("carbohydrates")
        private Double carbohydrates;


    public ProductModel(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, Integer weight, Integer calories, Double proteins, Double fats, Double carbohydrates) {
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

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
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

