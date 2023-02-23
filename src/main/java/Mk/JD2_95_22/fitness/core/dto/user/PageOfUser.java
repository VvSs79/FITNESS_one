package Mk.JD2_95_22.fitness.core.dto.user;

import java.util.List;

public class PageOfUser {
    private int number;

    private int size;

    private int totalPage;

    private long totalElements;

    private boolean first;

    private long numberOfElements;

    private boolean last;

    private List<User> content;

    public PageOfUser() {
    }

    public PageOfUser(int size, int totalPage, long totalElements, boolean first, long numberOfElements, boolean last, List<User> content) {
        this.size = size;
        this.totalPage = totalPage;
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<User> getContent() {
        return content;
    }

    public void setContent(List<User> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageOfUser{" +
                "number=" + number +
                ", size=" + size +
                ", totalPage=" + totalPage +
                ", totalElements=" + totalElements +
                ", first=" + first +
                ", numberOfElements=" + numberOfElements +
                ", last=" + last +
                ", content=" + content +
                '}';
    }
}
