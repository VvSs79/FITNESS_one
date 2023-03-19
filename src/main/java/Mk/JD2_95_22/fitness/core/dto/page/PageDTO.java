package Mk.JD2_95_22.fitness.core.dto.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageDTO<T>{
    @JsonProperty("number")
    @NotEmpty
    private int number;
    @JsonProperty("size")
    @NotEmpty
    private int size;

    @JsonProperty("total_pages")
    @NotEmpty
    private int totalPages;
    @JsonProperty("total_elements")
    @NotEmpty
    private long totalElements;
    @JsonProperty("first")
    @NotEmpty
    private boolean first;
    @JsonProperty("number_of_elements")
    @NotEmpty
    private int numberOfElements;
    @JsonProperty("last")
    @NotEmpty
    private boolean last;
    @JsonProperty("content")
    @NotEmpty
    private List<T> content;

    public PageDTO() {
    }

    public PageDTO(int number,
                 int size,
                 int totalPages,
                 long totalElements,
                 boolean first,
                 int numberOfElements,
                 boolean last,
                 List<T> content) {
            this.number = number;
            this.size = size;
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

        public static class PagesBuilder<T> {
            private int number;
            private int size;
            private int totalPages;
            private long totalElements;
            private boolean first;
            private int numberOfElements;
            private boolean last;
            private List<T> content;

            private PagesBuilder() {
            }

            public static <T> PagesBuilder<T> create() {
                return new PagesBuilder<T>();
            }

            public PagesBuilder<T> setNumber(int number) {
                this.number = number;
                return this;
            }

            public PagesBuilder<T> setSize(int size) {
                this.size = size;
                return this;
            }

            public PagesBuilder<T> setTotalPages(int totalPages) {
                this.totalPages = totalPages;
                return this;
            }

            public PagesBuilder<T> setTotalElements(long totalElements) {
                this.totalElements = totalElements;
                return this;
            }

            public PagesBuilder<T> setFirst(boolean first) {
                this.first = first;
                return this;
            }

            public PagesBuilder<T> setNumberOfElements(int numberOfElements) {
                this.numberOfElements = numberOfElements;
                return this;
            }

            public PagesBuilder<T> setLast(boolean last) {
                this.last = last;
                return this;
            }

            public PagesBuilder<T> setContent(List<T> content) {
                this.content = content;
                return this;
            }

            public PageDTO<T> build() {
                return new PageDTO<T>(
                        number,
                        size,
                        totalPages,
                        totalElements,
                        first,
                        numberOfElements,
                        last,
                        content);
            }
        }
    }

