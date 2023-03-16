package Mk.JD2_95_22.fitness.servise.validation;

import Mk.JD2_95_22.fitness.core.dto.products.Ingridients;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeCreatedForCU;
import Mk.JD2_95_22.fitness.core.exeption.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.exeption.MyError;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;

import java.util.List;

public class RecipeValidator implements IValidator<RecipeCreatedForCU> {
    public void validate(RecipeCreatedForCU recipeCreated) {
        MultipleErrorResponse multipleError = new MultipleErrorResponse();

        if(recipeCreated.getTitle() == null || recipeCreated.getTitle().isBlank()){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Field not entered", "title"));
        }
        if(recipeCreated.getComposition() == null || recipeCreated.getComposition().size() == 0){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Field not entered", "composition"));
        }
        List<Ingridients> ingredientEntityList = recipeCreated.getComposition();
        for (Ingridients ingredient : ingredientEntityList) {
            if(ingredient.getWeight() == 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be equal to 0", "weight"));
            }
            if(ingredient.getWeight() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be negative", "weight"));
            }

            if(ingredient.getProduct().getUuid() == null){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field not entered", "product"));
            }
        }
        if(multipleError.getErrors().size()>0){
            throw multipleError;
        }
    }
}
