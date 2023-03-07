package Mk.JD2_95_22.fitness.servise.api;


import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import jakarta.validation.ValidationException;

import java.time.Instant;
import java.util.UUID;

public interface IRecepteService {
    public void create(RecipeDTO recipe);
    public PageDTO<RecipeDTO> getPageRecipe(int page, int size);
    public void update(UUID id, Instant version, RecipeDTO product);
   void validate(RecipeDTO recipe);
   void checkDoubleRecipe(RecipeDTO recipe);
}
