package Mk.JD2_95_22.fitness.service.validate.api;

import Mk.JD2_95_22.fitness.service.validate.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Password can't be less than 7 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
