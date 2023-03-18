package Mk.JD2_95_22.fitness.servise.api.product;


import Mk.JD2_95_22.fitness.core.dto.model.RecipeJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeCreatedForCU;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

public interface IRecipeService {
    public void create( RecipeCreatedForCU recipe);
    public void add(@Validated RecipeCreatedForCU recipeDTO);
    public PageDTO<RecipeJsonModel> getPageRecipe(Pageable paging);
    public void update(RecipeDTO recipeDTO);
    public void checkDoubleRecipe(RecipeCreatedForCU recipe );


}
