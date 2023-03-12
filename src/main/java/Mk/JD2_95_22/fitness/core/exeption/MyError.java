package Mk.JD2_95_22.fitness.core.exeption;

public class Error {
    private String field;
    private String message;

    public Error(String error, String message) {
        this.field = error;
        this.message = message;
    }

    public String getError() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
