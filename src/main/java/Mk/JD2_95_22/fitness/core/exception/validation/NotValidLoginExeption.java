package Mk.JD2_95_22.fitness.core.exception.validation;

import jdk.jshell.spi.ExecutionControl;

public class NotValidLoginExeption extends RuntimeException {
    public NotValidLoginExeption() {
    }

    public NotValidLoginExeption(String message) {
        super(message);
    }

    public NotValidLoginExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidLoginExeption(Throwable cause) {
        super(cause);
    }

    public NotValidLoginExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
