package SpringBoot.MVC.controllers;

import SpringBoot.MVC.dao.BookDao;
import SpringBoot.MVC.models.Book;
import SpringBoot.MVC.models.BookStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class BooksController {

    private BookDao bookDao;

    @Autowired
    public BooksController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/")
    public String books(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books-list";
    }

    @GetMapping("/create-form")
    public String createForm() {
        return "create-form";
    }

    @PostMapping("/create")
    public String create(Book book) {
        bookDao.save(book);
        return "redirect:/";
    }

    @GetMapping("/invoice/{id}")
    public String invoice (@PathVariable("id") String id, Model model) {
       Book bookChek = BookStorage.getBooks().stream().
            filter(book->book.getId().equals(id)).
            findFirst().orElseThrow(RuntimeException::new);
        model.addAttribute("books",bookChek);
        return "invoice";
    }

    @GetMapping("/edit-form/{id}")
    public String createForm(@PathVariable("id") String id, Model model) {
        Book bookToEdit = bookDao.getById(id);
        model.addAttribute("book", bookToEdit);
        return "edit-form";
    }

    @GetMapping("/invoiceone")
    public String showbook (@PathVariable("id") String id) {
        Book show = BookStorage.getBooks().stream().
                filter(book -> book.getId().equals(id)).
                findFirst().
                orElseThrow(RuntimeException::new);
        BookStorage.getBooks().add(show);
        return "invoiceone";
    }


    @PostMapping("/update")
    public String update(Book book) {
        bookDao.update(book);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        bookDao.getById(id)
        bookDao.delete(bookDelete);
        return "redirect:/";
    }

}
