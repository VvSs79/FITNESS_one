package Mk.JD2_95_22.fitness.core.exception.validation;


import Mk.JD2_95_22.fitness.core.dto.erorr.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.dto.erorr.MyError;
import Mk.JD2_95_22.fitness.core.dto.recipe.RecipeCreate;
import Mk.JD2_95_22.fitness.core.dto.recipe.ingredient.IngredientCreate;
import Mk.JD2_95_22.fitness.core.exception.validation.api.IValidator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class RecipeValidator implements IValidator<RecipeCreate> {
    public void validate(RecipeCreate recipeCreated) {
        MultipleErrorResponse multipleError = new MultipleErrorResponse();

        if(recipeCreated.getTitle() == null || recipeCreated.getTitle().isBlank()){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Field not entered", "title"))));
        }
        if(recipeCreated.getComposition() == null || recipeCreated.getComposition().size() == 0){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Field not entered", "composition"))));
        }
        List<IngredientCreate> ingredientEntityList = recipeCreated.getComposition();
        for (IngredientCreate ingredient : ingredientEntityList) {
            if(ingredient.getWeight() == 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be equal to 0", "weight"))));
            }
            if(ingredient.getWeight() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "weight"))));
            }
        }
        if(multipleError.getErrors().size()>0){
            try {
                throw multipleError;
            } catch (MultipleErrorResponse e) {
                throw new RuntimeException(e);
            }
        }
    }
}
