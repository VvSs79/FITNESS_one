package Mk.JD2_95_22.fitness.servise.api.product;


import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Pageable;


import java.time.Instant;
import java.util.UUID;

public interface IRecepteService {
    public void create(RecipeDTO recipe);
    public PageDTO<RecipeDTO> getPageRecipe(Pageable pageable);
    public void update(UUID id, Instant version, RecipeDTO product, String title);
    public void validate(RecipeDTO recipe);
    public void checkDoubleRecipe(RecipeDTO recipe);
}
