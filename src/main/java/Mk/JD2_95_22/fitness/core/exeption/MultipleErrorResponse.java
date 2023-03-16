package Mk.JD2_95_22.fitness.core.exeption;

import java.util.ArrayList;
import java.util.List;

public class MultipleErrorResponse extends RuntimeException {
    private String logref;
    private List<MyError> error = new ArrayList<>();

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public List<MyError> getErrors() {
        return error;
    }

    public void setErrors(List<MyError> error) {
        this.error = error;
    }
    public void setErrors(MyError error) {
        this.error.add(error);
    }
}
