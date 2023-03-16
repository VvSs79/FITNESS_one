package Mk.JD2_95_22.fitness.servise.validation;

import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.core.exeption.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.exeption.MyError;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;

public class ProductValidator implements IValidator<ProductDTO> {
    public void validate(ProductDTO productDTO){
        MultipleErrorResponse multipleError=new MultipleErrorResponse();

            if(productDTO.getTitle() == null || productDTO.getTitle().isBlank()){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field not entered", "title"));
            }
            if(productDTO.getWeight() == 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be equal to 0", "weight"));
            }
            if(productDTO.getWeight() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be negative", "weight"));
            }
            if(productDTO.getCalories() == 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be equal to 0", "calories"));
            }
            if(productDTO.getCalories() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be negative", "calories"));
            }
            if(productDTO.getProteins() == 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be equal to 0", "proteins"));
            }
            if(productDTO.getProteins() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be negative", "proteins"));
            }
            if(productDTO.getFats() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be negative", "fats"));
            }
            if(productDTO.getCarbohydrates() == 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be equal to 0", "carbohydrates"));
            }
            if(productDTO.getCarbohydrates() < 0){
                if(multipleError.getLogref() == null){
                    multipleError.setLogref("structured_error");
                }
                multipleError.setErrors(new MyError("Field cannot be negative", "carbohydrates"));
            }
            if(multipleError.getErrors().size()>0){
                throw multipleError;
            }
}
}
