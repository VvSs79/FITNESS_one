package Mk.JD2_95_22.fitness.core.dto.recipe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.UUID;

public class RecipeUpdate {
    @NotEmpty
    private RecipeCreate recipeCreate;
    @NonNull
    private Instant dtUpdate;
    @NotBlank
    private UUID uuid;

    public RecipeUpdate(RecipeCreate recipeCreate, Instant dtUpdate, UUID uuid) {
        this.recipeCreate = recipeCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
    }

    public RecipeCreate getAddRecipeDTO() {
        return recipeCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setRecipeCreate(RecipeCreate recipeCreate) {
        this.recipeCreate = recipeCreate;
    }

    public void setDtUpdate(@NonNull Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
