package Mk.JD2_95_22.fitness.core.exception.my_exeption.validation;

public class ValidationExeption extends RuntimeException {
    public ValidationExeption() {
    }

    public ValidationExeption(String message) {
        super(message);
    }

    public ValidationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationExeption(Throwable cause) {
        super(cause);
    }

    public ValidationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
