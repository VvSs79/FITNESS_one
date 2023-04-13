package Mk.JD2_95_22.fitness.service.api.product;

import Mk.JD2_95_22.fitness.core.dto.j_model.RecipeJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.recipe.RecipeCreate;

import java.time.Instant;
import java.util.UUID;


public interface IRecipeService<T> {

//UUID create(RecipeCreate recipe);
//    PageDTO<RecipeJsonModel> get(int page, int size);
//    UUID update(RecipeUpdate recipe);

    UUID create(RecipeCreate recipe);
    PageDTO<RecipeJsonModel> get(int page, int size);
    UUID update(UUID id, Instant version, RecipeCreate product);
}
