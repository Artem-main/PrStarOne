package SpringBoot.MVC.dao;

import SpringBoot.MVC.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
        (properties = {"jdbcUrl=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookDaoImplTest {
    @Autowired
    private BookDao bookDao;

    @BeforeEach
    public void beforeEach () {
        bookDao.deleteAll();
    }

    @Test
    public void contextCreated () {
    }

    @Test
    public void save () {
        final Book saveBook = bookDao.save(new Book( 1, "qq", "aa",12));
        assertThat(saveBook.getId()).isNotBlank();
        assertThat(bookDao.findAll())
                .extracting("id")
                .containsExactly(saveBook.getId());
    }

    @Test
    public void findAll () {
        assertThat(bookDao.findAll()).isEmpty();
        bookDao.save(new Book( 1, "qq", "aa",12));
        assertThat (bookDao.findAll()).isNotEmpty();
    }

    @Test
    void deleteAll () {
        bookDao.save(new Book( 1, "qq", "aa",12));
        assertThat (bookDao.findAll()).isNotEmpty();
        bookDao.deleteAll();
        assertThat(bookDao.findAll()).isEmpty();
    }

    @Test
    public void getId () {
        Book one = bookDao.save(new Book( 1, "one", "aa",12));
        bookDao.save(new Book( 1, "two", "aa",12));

        assertThat(bookDao.getById(one.getId()))
                .isNotNull()
                .extracting("name")
                .isEqualTo(one.getName());

    }

    @Test
    void updateBook () {
        Book one = bookDao.save(new Book( 1, "one", "aa",12));
        one.setName("new one name");

        bookDao.update(one);

        assertThat(bookDao.getById(one.getId()).getName()).isEqualTo("new one name");
    }

    @Test
    void deleteBook () {
        Book bookToKeep = bookDao.save(new Book( 1, "one", "aa",12));
        Book bookTodelete = bookDao.save(new Book( 1, "delete", "aa",12));

        bookDao.delete(bookTodelete);

        assertThat(bookDao.getById(bookToKeep.getId())).isNotNull();
    }
}