package Mk.JD2_95_22.fitness.core.dto.erorr;

import java.util.List;

public class MultipleErrorResponse extends Throwable {
    String logref;
    List<MyError> errors;

    public MultipleErrorResponse(String logref, List<MyError> errors) {
        this.logref = logref;
        this.errors = errors;
    }

    public MultipleErrorResponse() {
    }

    public String getLogref() {
        return logref;
    }

    public List<MyError> getErrors() {
        return errors;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public void setErrors(List<MyError> errors) {
        this.errors = errors;
    }
}
