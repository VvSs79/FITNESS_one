package Mk.JD2_95_22.fitness.core.dto.erorr;

public class MyError {
    private String field;
    private String message;

    public MyError() {
    }

    public MyError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}