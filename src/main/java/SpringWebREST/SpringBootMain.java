package SpringWebREST;

//Реализовать Java-приложение с использованием Spring Framework для управления базой данных контактов
//       [x] Контакт имеет следующие характеристики – Имя и Фамилия, Телефонный номер, Email.
//       [] Приложение должно иметь следующие методы:
//          [x] GET /contacts для получения всех контактов
//          [x] GET /contact/{contactId} для получения конкретного контакта
//          [x] POST /contacts для добавления контакта (при создании контакту присваивается идентификатор)
//          [x] PUT /contacts/{contactId} для изменения уже существующей контактной информации
//          [] Приложение принимает и возвращает данные в формате JSON

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
