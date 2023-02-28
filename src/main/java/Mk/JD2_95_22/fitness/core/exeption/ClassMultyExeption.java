package Mk.JD2_95_22.fitness.core.exeption;

import java.util.List;

public class ClassMultyExeption {
    private String logref;
    private List<ClassError> errors;

    public ClassMultyExeption(String logref, List<ClassError> errors) {
        this.logref = logref;
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public List<ClassError> getErrors() {
        return errors;
    }
}
