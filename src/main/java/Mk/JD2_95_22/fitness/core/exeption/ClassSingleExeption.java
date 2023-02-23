package core.exeption;

public class ClassSingleExeption {
    private String logref;
    private String message;

    public ClassSingleExeption(String logref, String message) {
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
