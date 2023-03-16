package Mk.JD2_95_22.fitness.core.dto.products;

import Mk.JD2_95_22.fitness.converter.number_format.InstantConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class RecipeDTO  {
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
    private List<Ingridients> composition;
    private int weight;
    private int calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public RecipeDTO(@NonNull UUID uuid, Instant dtCreate, Instant dtUpdate, String title, List<Ingridients> composition, int weight, int calories, double proteins, double fats, double carbohydrates) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.composition = composition;
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

    public Instant getDtCreate() {
        return dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingridients> getComposition() {
        return composition;
    }

    public int getWeight() {
        return weight;
    }

    public int getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setUuid(@NonNull UUID uuid) {
        this.uuid = uuid;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposition(List<Ingridients> composition) {
        this.composition = composition;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeDTO recipeDTO = (RecipeDTO) o;
        return weight == recipeDTO.weight && calories == recipeDTO.calories && Double.compare(recipeDTO.proteins, proteins) == 0 && Double.compare(recipeDTO.fats, fats) == 0 && Double.compare(recipeDTO.carbohydrates, carbohydrates) == 0 && uuid.equals(recipeDTO.uuid) && Objects.equals(dtCreate, recipeDTO.dtCreate) && Objects.equals(dtUpdate, recipeDTO.dtUpdate) && Objects.equals(title, recipeDTO.title) && Objects.equals(composition, recipeDTO.composition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, dtCreate, dtUpdate, title, composition, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "uuid=" + uuid +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", title='" + title + '\'' +
                ", composition=" + composition +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
//
//    @NonNull private UUID uuid;
//    @JsonProperty("dt_create")
//    @JsonSerialize(converter = InstantConverter.Serializer.class)
//    @JsonDeserialize(converter = InstantConverter.Deserializer.class)
//    private Instant dtCreated;
//    @JsonProperty("dt_update")
//    @JsonSerialize(converter = InstantConverter.Serializer.class)
//    @JsonDeserialize(converter = InstantConverter.Deserializer.class)
//    private Instant dtUpdate;
//    @NotBlank(message = "Title must not be blank")
//    private String title;
//    private List<Ingridients> composition;
//
//    private int weight;
//    private int calories;
//    private double proteins;
//    private double fats;
//    private double carbohydrates;
//
//    public RecipeDTO() {
//    }
//
//    public RecipeDTO(@NonNull UUID uuid, Instant dtCreated, Instant dtUpdate, String title, List<Ingridients> composition, int weight, int calories, double proteins, double fats, double carbohydrates) {
//        this.uuid = uuid;
//        this.dtCreated = dtCreated;
//        this.dtUpdate = dtUpdate;
//        this.title = title;
//        this.composition = composition;
//        this.weight = weight;
//        this.calories = calories;
//        this.proteins = proteins;
//        this.fats = fats;
//        this.carbohydrates = carbohydrates;
//    }
//
//    @NonNull
//    public UUID getUuid() {
//        return uuid;
//    }
//
//    public Instant getDtCreated() {
//        return dtCreated;
//    }
//
//    public Instant getDtUpdate() {
//        return dtUpdate;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public List<Ingridients> getComposition() {
//        return composition;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public int getCalories() {
//        return calories;
//    }
//
//    public double getProteins() {
//        return proteins;
//    }
//
//    public double getFats() {
//        return fats;
//    }
//
//    public double getCarbohydrates() {
//        return carbohydrates;
//    }
//
//    public  static class RecipeBuilder{
//        private UUID uuid;
//        private Instant dtCreate;
//        private Instant dtUpdate;
//        private String title;
//        private List<Ingridients> composition;
//        private int weight;
//        private int calories;
//        private double proteins;
//        private double fats;
//        private double carbohydrates;
//
//        private RecipeBuilder() {
//        }
//        public static RecipeBuilder create(){
//            return new RecipeBuilder();
//        }
//
//        public RecipeBuilder setUuid(UUID uuid) {
//            this.uuid = uuid;
//            return this;
//        }
//
//        public RecipeBuilder setDtCreate(Instant dtCreate) {
//            this.dtCreate = dtCreate;
//            return this;
//        }
//
//        public RecipeBuilder setDtUpdate(Instant dtUpdate) {
//            this.dtUpdate = dtUpdate;
//            return this;
//        }
//
//        public RecipeBuilder setTitle(String title) {
//            this.title = title;
//            return this;
//        }
//
//        public RecipeBuilder setComposition(List<Ingridients> composition) {
//            this.composition = composition;
//            return this;
//        }
//
//        public RecipeBuilder setWeight(int weight) {
//            this.weight = weight;
//            return this;
//        }
//
//        public RecipeBuilder setCalories(int calories) {
//            this.calories = calories;
//            return this;
//        }
//
//        public RecipeBuilder setProteins(double proteins) {
//            this.proteins = proteins;
//            return this;
//        }
//
//        public RecipeBuilder setFats(double fats) {
//            this.fats = fats;
//            return this;
//        }
//
//        public RecipeBuilder setCarbohydrates(double carbohydrates) {
//            this.carbohydrates = carbohydrates;
//            return this;
//        }
//
//        public RecipeDTO build(){
//            return new RecipeDTO(uuid, dtCreate, dtUpdate, title, composition, weight, calories, proteins, fats, carbohydrates);
//        }
//    }
//
//
//}
