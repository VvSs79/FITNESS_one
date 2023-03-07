package Mk.JD2_95_22.fitness.core.exeption;

public class Error {
    private String error;
    private String message;

    public Error(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
