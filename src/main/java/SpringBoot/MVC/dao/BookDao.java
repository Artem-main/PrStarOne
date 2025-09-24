package SpringBoot.MVC.dao;

import SpringBoot.MVC.models.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll ();
    Book save (Book boook);
    Book getById (String bookId);
    Book update (Book book);
    void delete (Book book);
    void deleteAll();
}
