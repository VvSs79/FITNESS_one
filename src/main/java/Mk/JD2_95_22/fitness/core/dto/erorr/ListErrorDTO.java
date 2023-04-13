package Mk.JD2_95_22.fitness.core.dto.erorr;

import java.util.List;
import java.util.Objects;

public class ListErrorDTO {
    private String logref;
    private List<StructuredErrorDTO> errors;

    public ListErrorDTO() {
    }

    public ListErrorDTO(List<StructuredErrorDTO> errors) {
        this.logref = "structured_error";
        this.errors = errors;
    }

    public ListErrorDTO(String logref, List<StructuredErrorDTO> errors) {
        this.logref = logref;
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public List<StructuredErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<StructuredErrorDTO> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListErrorDTO that = (ListErrorDTO) o;
        return Objects.equals(logref, that.logref) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logref, errors);
    }
}
