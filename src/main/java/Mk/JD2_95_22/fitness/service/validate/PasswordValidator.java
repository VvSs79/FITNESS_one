package Mk.JD2_95_22.fitness.service.validate;

import Mk.JD2_95_22.fitness.service.validate.api.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String>{
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && value.length() < 8) {
            return false;
        }
        return true;

    }
}
