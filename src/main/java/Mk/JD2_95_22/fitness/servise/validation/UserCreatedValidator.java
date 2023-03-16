package Mk.JD2_95_22.fitness.servise.validation;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.exeption.MultipleErrorResponse;
import Mk.JD2_95_22.fitness.core.exeption.MyError;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;

import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class UserCreatedValidator implements IValidator<UserCreated> {

    private static final String EMAIL_REGEX =  "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+[.])+[a-z]{2,5}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final IUserRepository repository;

    public UserCreatedValidator(IUserRepository repository) {
        this.repository = repository;
    }
    public void validate(UserCreated userCreated){
        MultipleErrorResponse multipleError=new MultipleErrorResponse();

        if (userCreated.getMailUser()==null&&userCreated.getMailUser().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Mail not entered", "mail"));
        }

        if(userCreated.getPassword()==null||userCreated.getPassword().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Password not entered","password"));
        }
        if(userCreated.getPassword().length()<5){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Password must be longer than 5 characters","password"));
        }

        if(userCreated.getFIOuser()==null||userCreated.getFIOuser().isBlank()){
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("FIO not entered","fio"));
        }
        if(userCreated.getFIOuser().length()<7) {
            if(multipleError.getLogref()==null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("FIO must be longer than 7 characters","password"));
        }
        if(userCreated.getUserRole() == null){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Role not entered", "role"));
        }
        if(!Arrays.stream(UserRole.values()).anyMatch(element -> element == userCreated.getUserRole())){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("This role is absent", "role"));
        }

        if(userCreated.getUserStatus() == null){
            if(multipleError.getLogref() == null){
                multipleError.setLogref("structured_error");
            }
            multipleError.setErrors(new MyError("Status not entered", "status"));
        }

        if(!EMAIL_PATTERN.matcher(userCreated.getMailUser()).matches()){
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
