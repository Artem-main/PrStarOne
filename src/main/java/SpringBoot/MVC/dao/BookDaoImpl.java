package SpringBoot.MVC.dao;

import SpringBoot.MVC.models.Book;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao {
    private final DataSource dataSource;

    @Autowired
    public BookDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @SneakyThrows
    @Override
    public List<Book> findAll() {
        final String selectSql = "SELECT book_id, pages, name, author, sum FROM book";
        List<Book> books = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectSql);
                ) {
            while (rs.next()) {
                Book book = new Book(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                books.add(book);
            }
        }
        return books;
    }

    @SneakyThrows
    @Override
    public Book save(Book book) {
        String insertSql = "INSERT INTO book (pages, name, author, sum) VALUES (?, ?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(insertSql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setInt(1,book.getPages());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setInt(4,book.getSum());
            preparedStatement.executeUpdate();
            try (
                    ResultSet rs = preparedStatement.getGeneratedKeys()
                    ) {
                rs.next();
                book.setId(rs.getString(1));
            }
        }
        return book;
    }

    @SneakyThrows
    @Override
    public Book getById(String bookId) {
        String getByIdSql = "SELECT book_id, pages, name, author, sum FROM book WHERE book_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getByIdSql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setInt(1, Integer.parseInt(bookId));
            try (
                    ResultSet rs = preparedStatement.executeQuery();
                    ) {
                if (!rs.next()) {
                    throw new RuntimeException(String.format("Book with id %d was not found", bookId));
                }
                return new Book(rs.getString(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5));

            }
        }
    }

    @SneakyThrows
    @Override
    public Book update(Book book) {
        String updateSql = "UPDATE book SET pages = ?, name = ?, author = ?, sum = ? WHERE book_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(updateSql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setInt(1,book.getPages());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setInt(4,book.getSum());
            preparedStatement.setString(5,book.getId());
            preparedStatement.executeUpdate();

        }
        return book;
    }

    @SneakyThrows
    @Override
    public void delete(Book book) {
        final String deleteSql = "DELETE FROM book WHERE book_id=?";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(deleteSql);
        statement.setString(1,book.getId());
        statement.executeUpdate();
    }

    @SneakyThrows
    @Override
    public void deleteAll() {
        final String deleteAllSql = "TRUNCATE TABLE book";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(deleteAllSql);
    }
}
