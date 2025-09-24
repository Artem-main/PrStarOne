package SpringBoot.MVC;

import SpringBoot.MVC.models.Book;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Application {

    @Bean
    public DataSource h2DataSourse (@Value("${jdbcUrl}") String jdbcUrl) {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUser("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public CommandLineRunner cmd (DataSource dataSource) {
        return args -> {
            try (
                    InputStream inputStream = this.getClass().getResourceAsStream("/initial.sql");
                    Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(reader)
            ) {
                StringBuilder sql = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    sql.append(line).append("\n");
                }

                try (
                        Connection connection = dataSource.getConnection();
                        Statement statement = connection.createStatement()
                ) {
                    statement.executeUpdate(sql.toString());
                    String insertSql = "INSERT INTO book (pages, name, author, sum) VALUES (?, ?, ?, ?)";
                    try (
                            PreparedStatement preparedStatement = connection.prepareStatement(insertSql)
                            ) {
                        preparedStatement.setInt(1,123);
                        preparedStatement.setString(2, "NEW");
                        preparedStatement.setString(3,"SQL");
                        preparedStatement.setInt(4,321);
                        preparedStatement.executeUpdate();
                    }
                    System.out.println("Инициализация БД");
                    ResultSet rs = statement.executeQuery("SELECT book_id, pages, name, author, sum FROM book");
                    while (rs.next()) {
                        Book book = new Book(rs.getString(1), rs.getInt(2),
                                rs.getString(3), rs.getString(4), rs.getInt(5));
                        System.out.println(book);
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
