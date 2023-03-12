package Mk.JD2_95_22.fitness.core.exeption;

import java.util.List;

public class MultyError extends RuntimeException{
    private String logref;
    private List<MyError> errors;

    public MultyError(String logref, List<MyError> errors) {
        this.logref = logref;
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public List<MyError> getErrors() {
        return errors;
    }
}
