package Mk.JD2_95_22.fitness.core.exception.check_exeptions;

public class DoubleException extends RuntimeException {
    public DoubleException() {
    }

    public DoubleException(String message) {
        super(message);
    }

    public DoubleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoubleException(Throwable cause) {
        super(cause);
    }

    public DoubleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
