package Mk.JD2_95_22.fitness.core.dto.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageDTO<T>{
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
    private int numberElements;
    @JsonProperty("last")
    private boolean last;
    @JsonProperty("content")
    private List<T> content;

    public PageDTO() {
    }

    public PageDTO(int number, int size,
                   int totalPages, long totalElements,
                   boolean first, int numberElements,
                   boolean last, List<T> content) {
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.first = first;
        this.numberElements = numberElements;
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

    public int getNumberElements() {
        return numberElements;
    }

    public void setNumberElements(int numberElements) {
        this.numberElements = numberElements;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageDTO<?> pageDTO = (PageDTO<?>) o;
        return number == pageDTO.number && size == pageDTO.size && totalPages == pageDTO.totalPages && totalElements == pageDTO.totalElements && first == pageDTO.first && numberElements == pageDTO.numberElements && last == pageDTO.last && Objects.equals(content, pageDTO.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size, totalPages, totalElements, first, numberElements, last, content);
    }
    @Override
    public String toString() {
        return "PageDTO{" +
                "number=" + number +
                ", size=" + size +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", first=" + first +
                ", numberElements=" + numberElements +
                ", last=" + last +
                ", content=" + content +
                '}';
    }
}
