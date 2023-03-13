package Mk.JD2_95_22.fitness.servise.my_exeption.version;

public class InvalidVersionExeption extends RuntimeException {
    public InvalidVersionExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidVersionExeption() {
    }

    public InvalidVersionExeption(String message) {
        super(message);
    }

    public InvalidVersionExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVersionExeption(Throwable cause) {
        super(cause);
    }
}
