package Mk.JD2_95_22.fitness.core.exception.validation;


import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.core.exception.validation.api.IValidator;
import Mk.JD2_95_22.fitness.core.dto.erorr.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.dto.erorr.MyError;
import Mk.JD2_95_22.fitness.orm.repository.user.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.regex.Pattern;

@Component
public class UserRegistrationValidator implements IValidator<UserRegistration> {
    private static final String EMAIL_REGEX =  "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+[.])+[a-z]{2,5}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final IUserRepository repository;

    public UserRegistrationValidator (IUserRepository repository) {
        this.repository = repository;
    }

    public void validate(UserRegistration userRegistration) {
        MultipleErrorResponse multipleError=new MultipleErrorResponse();

        if (userRegistration.getMail()==null||userRegistration.getMail().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Mail not entered", "mail"))));
        }



        if(userRegistration.getPassword()==null||userRegistration.getPassword().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
        }
            multipleError.setErrors((Collections.singletonList(new MyError("Password not entered","password"))));
    }
        if(userRegistration.getPassword().length()<5){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Password must be longer than 5 characters","password"))));
        }

        if(userRegistration.getFio()==null||userRegistration.getFio().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("FIO not entered","fio"))));
        }
        if(userRegistration.getFio().length()<7) {
            if(multipleError.getLogref()==null){
            multipleError.setLogref("structured_error");
        }
        multipleError.setErrors((Collections.singletonList(new MyError("FIO must be longer than 7 characters","password"))));
    }


        if(!EMAIL_PATTERN.matcher(userRegistration.getMail()).matches()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Incorrect email format","mail"))));
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
