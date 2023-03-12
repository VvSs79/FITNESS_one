package Mk.JD2_95_22.fitness.core.exeption;

import java.util.Objects;

public class Error {
    private String message;

    private String logref;

    public Error(String message, String logref) {
        this.message = message;
        this.logref = logref;
    }

    public Error(String message) {
        this.message = message;
        this.logref = "error";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(message, error.message) && Objects.equals(logref, error.logref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, logref);
    }
}
