package Mk.JD2_95_22.fitness.core.exception.validation;


import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.erorr.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.dto.erorr.MyError;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserRole;
import Mk.JD2_95_22.fitness.core.exception.validation.api.IValidator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.regex.Pattern;
@Component
public class UserCreatedValidator implements IValidator<UserCreate> {
    private static final String EMAIL_REGEX =  "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+[.])+[a-z]{2,5}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    public void validate(UserCreate userCreated){
        MultipleErrorResponse multipleError=new MultipleErrorResponse();

        if (userCreated.getMail()==null&&userCreated.getMail().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Mail not entered", "mail"))));
        }

        if(userCreated.getPassword()==null||userCreated.getPassword().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Password not entered","password"))));
        }
        if(userCreated.getPassword().length()<5){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Password must be longer than 5 characters","password"))));
        }

        if(userCreated.getFio()==null||userCreated.getFio().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("FIO not entered","fio"))));
        }
        if(userCreated.getFio().length()<7) {
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("FIO must be longer than 7 characters","password"))));
        }
        if(userCreated.getRole() == null){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Role not entered", "role"))));
        }
        boolean b = true;
        for (UserRole element : UserRole.values()) {
            if (element == userCreated.getRole()) {
                b = false;
                break;
            }
        }
        if(b){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("This role is absent", "role"))));
        }

        if(userCreated.getStatus() == null){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors((Collections.singletonList(new MyError("Status not entered", "status"))));
        }

        if(!EMAIL_PATTERN.matcher(userCreated.getMail()).matches()){
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
