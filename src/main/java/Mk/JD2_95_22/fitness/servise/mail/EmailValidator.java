package Mk.JD2_95_22.fitness.servise.mail;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    private final String EMAIL_PATTERN = "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+[.])+[a-z]{2,5}$";

    @Override
    public boolean test(String email) {

        return email.matches(EMAIL_PATTERN);
    }
}
