package SpringBoot.MVC.controllers;

import SpringBoot.MVC.models.BooksStorage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static java.lang.String.format;

@RestController
public class TestController {

    @RequestMapping ("/")
    public String startText () {
        return "Controller started!\n";
    }

    @RequestMapping ("/books")
    public String books () {
        return BooksStorage.getBooks().
                stream().
                map(book -> format ("%s - %s - %s",
                        book.getAuthor(), book.getName(), book.getPages())).
                collect(Collectors.joining("</br>"));
    }
}
