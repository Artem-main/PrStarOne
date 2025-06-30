package SpringBoot.MVC.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BookStorage {

    private static Set<Book> books = new HashSet<>();

    static {
        books.add(new Book("1", 416, "Учение Дона Хуана", "Карлос Кастанеда",11));
        books.add(new Book(UUID.randomUUID().toString(), 352, "Богатый папа, бедный папа", "Роберт Киосаки",11));
    }

    public static Set<Book> getBooks() {
        return books;
    }
}
