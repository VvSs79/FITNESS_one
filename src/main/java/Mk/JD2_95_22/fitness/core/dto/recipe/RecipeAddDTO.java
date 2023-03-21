package Mk.JD2_95_22.fitness.core.dto.recipe;

import java.time.Instant;

public class RecipeAddDTO {
    private RecipeCreate recipeCreate;
    private Instant dtCreate;
    private Instant dtUpdate;

    public RecipeCreate getAddRecipeDTO() {
        return recipeCreate;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public void setRecipeCreate(RecipeCreate recipeCreate) {
        this.recipeCreate = recipeCreate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public RecipeAddDTO(RecipeCreate recipeCreate) {
        this.recipeCreate = recipeCreate;
        this.dtCreate = Instant.now();
        this.dtUpdate = this.dtCreate;
    }
}
