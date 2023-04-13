package Mk.JD2_95_22.fitness.core.dto.erorr;

import java.util.Objects;

public class ErrorDTO {
    private String logref;
    private String message;

    public ErrorDTO() {
    }

    public ErrorDTO(String logref, String message) {
        this.logref = "error";
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDTO errorDTO = (ErrorDTO) o;
        return Objects.equals(logref, errorDTO.logref) && Objects.equals(message, errorDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logref, message);
    }
}