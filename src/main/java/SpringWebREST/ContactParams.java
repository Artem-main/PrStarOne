package SpringWebREST;

public class ContactParams {
    private final String name;
    private final String surname;
    private final long phoneNumber;
    private final String email;
    private final int id;

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ContactParams(int id, String name, String surname, long phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
    }
}
