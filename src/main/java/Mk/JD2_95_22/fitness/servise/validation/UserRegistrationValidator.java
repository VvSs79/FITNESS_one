package Mk.JD2_95_22.fitness.servise.validation;

import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.core.exeption.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.exeption.MyError;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;


import java.util.regex.Pattern;

public class UserRegistrationValidator implements IValidator<UserRegistration> {
    private static final String EMAIL_REGEX =  "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+[.])+[a-z]{2,5}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final IUserRepository repository;

    public UserRegistrationValidator (IUserRepository repository) {
        this.repository = repository;
    }

    public void validate(UserRegistration userRegistration) {
        MultipleErrorResponse multipleError=new MultipleErrorResponse();

        if (userRegistration.getMailUser()==null||userRegistration.getMailUser().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Mail not entered", "mail"));
        }



        if(userRegistration.getPassword()==null||userRegistration.getPassword().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
        }
            multipleError.setErrors(new MyError("Password not entered","password"));
    }
        if(userRegistration.getPassword().length()<5){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Password must be longer than 5 characters","password"));
        }

        if(userRegistration.getFIOuser()==null||userRegistration.getFIOuser().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("FIO not entered","fio"));
        }
        if(userRegistration.getFIOuser().length()<7) {
            if(multipleError.getLogref()==null){
            multipleError.setLogref("structured_error");
        }
        multipleError.setErrors(new MyError("FIO must be longer than 7 characters","password"));
    }


        if(!EMAIL_PATTERN.matcher(userRegistration.getMailUser()).matches()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Incorrect email format","mail"));
        }
        if(multipleError.getErrors().size()>0){
            throw multipleError;
        }
    }
}
