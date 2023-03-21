package Mk.JD2_95_22.fitness.core.exception.my_exeption.page;

import io.jsonwebtoken.JwtException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;

public class PageNotFoundExeption extends RuntimeException{
    public PageNotFoundExeption(){};
    public PageNotFoundExeption(String message) {
        super(message);
    }

    public PageNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
