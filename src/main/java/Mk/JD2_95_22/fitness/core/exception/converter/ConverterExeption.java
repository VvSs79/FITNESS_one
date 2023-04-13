package Mk.JD2_95_22.fitness.core.exception.converter;

public class ConverterExeption extends  RuntimeException{
    public ConverterExeption() {
    }

    public ConverterExeption(String message) {
        super(message);
    }

    public ConverterExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ConverterExeption(Throwable cause) {
        super(cause);
    }

    public ConverterExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
