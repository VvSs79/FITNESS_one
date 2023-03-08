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

    public RecipeDTO(String title, List<Ingridients> composition) {
        this.title = title;
        this.composition = composition;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingridients> getComposition() {
        return composition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposition(List<Ingridients> composition) {
        this.composition = composition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeDTO recipe = (RecipeDTO) o;
        return Objects.equals(title, recipe.title) && Objects.equals(composition, recipe.composition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, composition);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", composition=" + composition +
                '}';
    }
}
