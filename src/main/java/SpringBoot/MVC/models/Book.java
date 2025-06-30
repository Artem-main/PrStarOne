package SpringBoot.MVC.models;
public class Book {
    private String id;
    private int pages;
    private String name;
    private String author;
    private int sum;

    public Book(String id, int pages, String name, String author, int sum) {
        this.id = id;
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.sum = sum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}