//package Mk.JD2_95_22.fitness.service.validate;
//
//
//
//import Mk.JD2_95_22.fitness.core.dto.erorr.ErrorDTO;
//import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
//
//import Mk.JD2_95_22.fitness.core.exception.user.UserValidateExeption;
//import Mk.JD2_95_22.fitness.orm.repository.user.IUserRepository;
//import Mk.JD2_95_22.fitness.service.validate.api.IValidator;
//import org.springframework.stereotype.Component;
//
//import java.util.regex.Pattern;
//
//@Component
//public class UserRegistrationValidator implements IValidator<UserRegistration> {
//
//
//    public void validate(UserRegistration userRegistration) {
//      ErrorDTO multipleError=new ErrorDTO();
//      UserValidateExeption exeption=new UserValidateExeption();
//
//        if (userRegistration.getMail()==null||userRegistration.getMail().isBlank()){
//            if(multipleError.getLogref()==null){
//                multipleError.setLogref("structured_error");
//            }
//            exeption.addSuppressed(new UserValidateExeption("mail not entered"));
//
//        }
//
//        if(userRegistration.getPassword()==null||userRegistration.getPassword().isBlank()){
//            if(multipleError.getLogref()==null){
//                multipleError.setLogref("structured_error");
//            }
//            exeption.addSuppressed(new UserValidateExeption("password not entered"));
//        }
//
//        if(userRegistration.getPassword().length()<5){
//            if(multipleError.getLogref()==null){
//                multipleError.setLogref("structured_error");
//            }
//            exeption.addSuppressed(new UserValidateExeption("Password must be longer than 7 characters"));
//        }
//
//        if(userRegistration.getFio()==null||userRegistration.getFio().isBlank()){
//            if(multipleError.getLogref()==null){
//                multipleError.setLogref("structured_error");
//            }
//            exeption.addSuppressed(new UserValidateExeption("password not entered"));
//        }
//
//        if(userRegistration.getFio().length()<7) {
//            if(multipleError.getLogref()==null){
//            multipleError.setLogref("structured_error");
//        }
//            exeption.addSuppressed(new UserValidateExeption("FIO must be longer than 7 characters"));
//    }
//        if(exeption.getSuppressed().length>0){
//            throw exeption;
//        }
//
//
//
////        if(multipleError.getErrors().size()>0){
////            try {
////                throw multipleError;
////            } catch (MultipleErrorResponse e) {
////                throw new RuntimeException(e);
////            }
////        }
//    }
//}
