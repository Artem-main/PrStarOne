package SpringWebREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final ClientService clientService;

    @Autowired
    //говорит спрингу, что в этом месте необходимо внедрить зависимость.
    //В конструктор мы передаем интерфейс ClientService.
    // Реализацию данного сервиса мы пометили аннотацией @Service ранее,
    // и теперь спринг сможет передать экземпляр этой реализации в конструктор контроллера.
    public Controller (ClientService clientService) {
        this.clientService = clientService;
    }


    //    ResponseEntity — специальный класс для возврата ответов.
    //    С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
    // Метод принимает параметр @RequestBody Client client, значение этого параметра подставляется из тела запроса.
    @PostMapping("/contacts")
    public ResponseEntity<?> create (@RequestBody ContactParams contactParams) {
        clientService.post(contactParams);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactParams> get(@PathVariable(name = "id") int id) {
        final ContactParams contactParams = clientService.get(id);
        return contactParams != null
                ? new ResponseEntity<>(contactParams, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ContactParams>> read() {
        final List<ContactParams> clients = clientService.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ContactParams client) {
        final boolean updated = clientService.put(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
