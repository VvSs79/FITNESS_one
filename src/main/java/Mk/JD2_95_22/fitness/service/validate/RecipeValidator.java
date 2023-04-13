package Mk.JD2_95_22.fitness.service.validate;


import Mk.JD2_95_22.fitness.core.dto.nutrition.recipe.RecipeCreate;
import Mk.JD2_95_22.fitness.core.dto.nutrition.ingredient.IngredientCreate;
import Mk.JD2_95_22.fitness.core.exception.product.RecipeValidateExeption;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.service.validate.api.IValidator;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RecipeValidator implements IValidator<RecipeCreate> {
    private final IProductService service;
    public RecipeValidator(IProductService service) {
        this.service = service;
    }

    public void validate(RecipeCreate recipeCreated) {
        RecipeValidateExeption recipeValidateExeption=new RecipeValidateExeption();
        String title= recipeCreated.getTitle();
        if(title==null ||title.isBlank()){
            recipeValidateExeption
                    .addSuppressed(new RecipeValidateExeption(
                    "title",new Throwable("Title not entered")));
        }

        List<IngredientCreate> composition = recipeCreated.getComposition();
        for (IngredientCreate ingredient : composition) {
            if(ingredient.getProduct()!=null){
                try{
                    service.getProduct(ingredient.getProduct());
                }catch (RuntimeException e){
                    recipeValidateExeption
                            .addSuppressed(new RecipeValidateExeption(
                            "product", new Throwable(ingredient.getProduct() + " does not exist")));
                }
            } else {
                recipeValidateExeption
                        .addSuppressed(new RecipeValidateExeption(
                        "product", new Throwable("Must not be blank")));
            }

            if(ingredient.getWeight()<=0 || ingredient.getWeight()==null){
                recipeValidateExeption
                        .addSuppressed(new RecipeValidateExeption("weight", new Throwable("Should be positive or zero")) );
            }
        }

        if (recipeValidateExeption.getSuppressed().length>0){
            throw recipeValidateExeption;
        }
    }
}
//        MultipleErrorResponse multipleError = new MultipleErrorResponse();
//
//        if(recipeCreated.getTitle() == null || recipeCreated.getTitle().isBlank()){
//            if(multipleError.getLogref() == null){
//                multipleError.setLogref("structured_error");
//            }
//            multipleError.setErrors((Collections.singletonList(new MyError("Field not entered", "title"))));
//        }
//        if(recipeCreated.getComposition() == null || recipeCreated.getComposition().size() == 0){
//            if(multipleError.getLogref() == null){
//                multipleError.setLogref("structured_error");
//            }
//            multipleError.setErrors((Collections.singletonList(new MyError("Field not entered", "composition"))));
//        }
//        List<IngredientCreate> ingredientEntityList = recipeCreated.getComposition();
//        for (IngredientCreate ingredient : ingredientEntityList) {
//            if(ingredient.getWeight() == 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be equal to 0", "weight"))));
//            }
//            if(ingredient.getWeight() < 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "weight"))));
//            }
//        }
//        if(multipleError.getErrors().size()>0){
//            try {
//                throw multipleError;
//            } catch (MultipleErrorResponse e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

