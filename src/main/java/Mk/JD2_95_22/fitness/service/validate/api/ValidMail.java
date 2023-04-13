package Mk.JD2_95_22.fitness.service.validate.api;

import Mk.JD2_95_22.fitness.service.validate.MailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= MailValidator.class)
public @interface ValidMail {
    String message() default "Email not validated";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
