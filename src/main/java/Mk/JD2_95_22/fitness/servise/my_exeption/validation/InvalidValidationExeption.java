package Mk.JD2_95_22.fitness.servise.my_exeption.validation;

public class InvalidValidationExeption extends RuntimeException {
    public InvalidValidationExeption() {
    }

    public InvalidValidationExeption(String message) {
        super(message);
    }

    public InvalidValidationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValidationExeption(Throwable cause) {
        super(cause);
    }

    public InvalidValidationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
