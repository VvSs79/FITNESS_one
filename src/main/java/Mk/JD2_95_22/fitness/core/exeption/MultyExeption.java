package Mk.JD2_95_22.fitness.core.exeption;

import java.util.List;

public class MultyExeption {
    private String logref;
    private List<Error> errors;

    public MultyExeption(String logref, List<Error> errors) {
        this.logref = logref;
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
