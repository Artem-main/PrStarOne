package SpringWebREST;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientRealisation implements ClientService{

    // Хранилище контактов
    private static final Map<Integer, ContactParams> CLIENT_REPOSITORY_MAP = new HashMap<>();
    // Переменная для генерации ID контакта
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();


    @Override
    public void post(ContactParams contactParams) {
        final int contactId = CLIENT_ID_HOLDER.incrementAndGet();
        contactParams.setId(contactId);
        CLIENT_REPOSITORY_MAP.put(contactId, contactParams);
    }

    @Override
    public ContactParams get(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean put(ContactParams contactParams, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            contactParams.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, contactParams);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null ;
    }

    @Override
    public List<ContactParams> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }
}
