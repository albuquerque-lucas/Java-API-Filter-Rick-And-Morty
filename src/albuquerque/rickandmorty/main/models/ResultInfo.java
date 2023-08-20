package albuquerque.rickandmorty.main.models;

public class ResultInfo {
    private int count;
    private int pages;
    private String next;
    private String prev;

    public ResultInfo(int count, int pages, String next, String prev) {
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }

    public String getPrev() {
        return prev;
    }
}
