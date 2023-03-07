package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeCreated;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;

import java.awt.print.Pageable;
import java.time.Instant;
import java.util.UUID;

public interface IRecepteService {
    void add(RecipeCreated newRecipe);
    PageDTO<RecipeDTO> getAll(Pageable pageable);
    void update(UUID uuid, Instant dt_update,RecipeCreated recipeCreated);
}
