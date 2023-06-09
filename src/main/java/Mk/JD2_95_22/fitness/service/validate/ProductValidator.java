//package Mk.JD2_95_22.fitness.service.validate;
//
//
//import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductCreate;
//import Mk.JD2_95_22.fitness.service.validate.api.IValidator;
//import org.springframework.stereotype.Component;
//
//
//@Component
//
//public class ProductValidator implements IValidator<ProductCreate> {
//    public void validate(ProductCreate product){
//        MultipleErrorResponse multipleError=new MultipleErrorResponse();
//
//            if(product.getTitle() == null || product.getTitle().isBlank()){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors(Collections.singletonList(new MyError("Field not entered", "title")));
//            }
//            if(product.getWeight() == 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors(Collections.singletonList(new MyError("Field cannot be equal to 0", "weight")));
//            }
//            if(product.getWeight() < 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "weight"))));
//            }
//            if(product.getCalories() == 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be equal to 0", "calories"))));
//            }
//            if(product.getCalories() < 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "calories"))));
//            }
//            if(product.getProteins() == 0.0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be equal to 0", "proteins"))));
//            }
//            if(product.getProteins() < 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "proteins"))));
//            }
//            if(product.getFats() < 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "fats"))));
//            }
//            if(product.getCarbohydrates() == 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be equal to 0", "carbohydrates"))));
//            }
//            if(product.getCarbohydrates() < 0){
//                if(multipleError.getLogref() == null){
//                    multipleError.setLogref("structured_error");
//                }
//                multipleError.setErrors((Collections.singletonList(new MyError("Field cannot be negative", "carbohydrates"))));
//            }
////        if(multipleError.getErrors().size()>0){
////            try {
////                throw multipleError;
////            } catch (MultipleErrorResponse e) {
////                throw new RuntimeException(e);
////            }
////        }
//    }
//}}
