package Mk.JD2_95_22.fitness.core.dto.recipe;

import Mk.JD2_95_22.fitness.core.dto.recipe.ingredient.IngredientCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class RecipeCreate {
    @NotBlank
    private String title;
    @NotEmpty
    private List<IngredientCreate> composition;

    public String getTitle() {
        return title;
    }

    public List<IngredientCreate> getComposition() {
        return composition;
    }

    public RecipeCreate() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposition(List<IngredientCreate> composition) {
        this.composition = composition;
    }

    public RecipeCreate(String title, List<IngredientCreate> composition) {
        this.title = title;
        this.composition = composition;
    }
}
