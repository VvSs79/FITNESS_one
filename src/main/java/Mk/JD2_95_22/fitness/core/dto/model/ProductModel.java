package Mk.JD2_95_22.fitness.core.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import it.academy.fitness_studio.core.converter.CustomInstantConverter;
import java.time.Instant;
import java.util.UUID;

public class ProductModel {
    @JsonIgnoreProperties
    public class ProductModel {
        @JsonProperty("uuid")
        private UUID uuid;
        @JsonSerialize(converter = InstantConverter.InstantConverter.Serializer.class)
        @JsonProperty("dtcreate")
        private Instant dtCreate;
        @JsonSerialize(converter = InstantConverter.Serializer.class)
        @JsonProperty("dtupdate")
        private Instant dtUpdate;
        @JsonProperty("title")
        private String title;
        @JsonProperty("weight")
        private Integer weight;
        @JsonProperty("calories")
        private Integer calories;
        @JsonProperty("proteins")
        private Double proteins;
        @JsonProperty("fats")
        private Double fats;
        @JsonProperty("carbohydrates")
        private Double carbohydrates;
}
