package Mk.JD2_95_22.fitness.service.validate;

import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
public class MailValidator implements ConstraintValidator<ValidMail, String >{
public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!#$%&'*+/=?^_`{|},~\\-]+(?:\\\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~\\-]+)*@+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?+\\.+[a-zA-Z]*$");

        return value != null && pattern.matcher(value).matches();
        }
}
