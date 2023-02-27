package Mk.JD2_95_22.fitness.core.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageModel<T> {
    @JsonProperty("number")
    private int number;
    @JsonProperty("size")
    private int size;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_elements")
    private long totalElements;
    @JsonProperty("first")
    private boolean first;
    @JsonProperty("number_of_elements")
    private int numberOfElements;
    @JsonProperty("last")
    private boolean last;
    @JsonProperty("content")
    private List<T> content;

    public PageModel() {
    }

    public PageModel(int number, int size, int totalPages, long totalElements, boolean first, int numberOfElements, boolean last, List<T> content) {
        this.number = number;
        this.size = 20;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.first = first;
        this.numberOfElements = numberOfElements;
        this.last = last;
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
