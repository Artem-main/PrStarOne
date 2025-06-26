package SpringBoot.MVC;

import SpringBoot.MVC.models.Book;
import SpringBoot.MVC.models.BooksStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        BooksStorage.getBooks().add(
                new Book(UUID.randomUUID().toString(),"FirstBook","Ivan",100)
        );
        BooksStorage.getBooks().add(
                new Book(UUID.randomUUID().toString(),"SecondBook","Petr",200)
        );
        SpringApplication.run(Application.class, args);
    }
}
