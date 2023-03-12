package Mk.JD2_95_22.fitness.core.exeption;

import java.util.Objects;

public class MyError {
    private String field;
    private String message;

    public MyError(String error, String message) {
        this.field = error;
        this.message = message;
    }

    public String getError() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyError myError = (MyError) o;
        return Objects.equals(field, myError.field) && Objects.equals(message, myError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, message);
    }

    @Override
    public String toString() {
        return "MyError{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
