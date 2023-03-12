package Mk.JD2_95_22.fitness.core.exeption;

import java.util.ArrayList;
import java.util.List;

public class SingleError extends RuntimeException {
    private List<Error> errorList=new ArrayList<>();

    public SingleError(String message, String logref) {
        this.errorList.add(new Error(message, logref));
    }

    public SingleError(String message) {
        this.errorList.add(new Error(message));
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }

    public void setErrorList(Error errorList) {
        this.errorList.add(errorList);
    }
}
