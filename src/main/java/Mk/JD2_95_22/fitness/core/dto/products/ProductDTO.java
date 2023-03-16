package Mk.JD2_95_22.fitness.core.dto.products;

import Mk.JD2_95_22.fitness.converter.number_format.InstantConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import java.time.Instant;
import java.util.UUID;

public class ProductDTO  {
    @NonNull private UUID uuid;
    @JsonProperty("dt_create")
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter = InstantConverter.Deserializer.class)
    private Instant dtCreate;
    @JsonProperty("dt_update")
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter = InstantConverter.Deserializer.class)
    private Instant dtUpdate;
    @NotBlank(message = "Title must not be blank")
    private String title;
    @NotBlank(message = "Weight should not be less than 1")
    @Min(value = 1)
    private Integer weight;
    @NotBlank(message = "Calories should not be less than 1 ")
    @Min(value = 1)
    private Integer calories;
    @NotBlank(message = "Proteins should not be less than 1 ")
    @Min(value = 0)
    private double proteins;
    @NotBlank(message = "Fats should not be less than 0 ")
    @Min(value = 0)
    private double fats;
    @NotBlank(message = "Carbohydrates should not be less than 10")
    @Min(value = 0)
    private double carbohydrates;

    public ProductDTO(UUID uuid, Instant dtCreate, Instant dtUpdate, String title, Integer weight, Integer calories, double proteins, double fats, double carbohydrates) {
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

    @NonNull
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull UUID uuid) {
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
}
