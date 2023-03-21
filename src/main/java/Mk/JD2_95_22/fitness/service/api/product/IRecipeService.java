package Mk.JD2_95_22.fitness.service.api.product;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.recipe.RecipeCreate;
import Mk.JD2_95_22.fitness.core.dto.recipe.RecipeUpdate;


public interface IRecipeService<T> {
    void create(RecipeCreate recipeDTO);

    PageDTO<T> get(int page, int size);

    void update(RecipeUpdate recipeDTO);
}
