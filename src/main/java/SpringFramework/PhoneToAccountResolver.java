package SpringFramework;

import java.util.Optional;

public interface PhoneToAccountResolver {

    Optional<Account> findAcccountByPhoneNumber (String phoneNumber);
    void addMapping (String phoneNumber, Account account);
    void removeMapping (String phoneNumber);
}
