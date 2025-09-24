package SpringBoot.MVC.models;

import lombok.Getter;

@Getter
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

    public Book(int pages, String name, String author, int sum) {
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sum=" + sum +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}