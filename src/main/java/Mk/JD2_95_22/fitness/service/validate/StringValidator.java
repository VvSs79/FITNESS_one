package Mk.JD2_95_22.fitness.service.validate;


import Mk.JD2_95_22.fitness.service.validate.api.ValidString;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<ValidString, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isBlank() || value.isEmpty()) {
            return false;
        }
        return true;
    }
}
