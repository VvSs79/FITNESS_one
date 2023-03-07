package Mk.JD2_95_22.fitness.core.exeption;

public class SingleExeption {
    private String logref;
    private String message;

    public SingleExeption(String logref, String message) {
        this.logref = logref;
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public String getMessage() {
        return message;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
