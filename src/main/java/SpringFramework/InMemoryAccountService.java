package SpringFramework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryAccountService implements AccountService {

    private final PhoneToAccountResolver phoneToAccountResolver;

    @Autowired
    public InMemoryAccountService(PhoneToAccountResolver phoneToAccountResolver) {
        this.phoneToAccountResolver = phoneToAccountResolver;
    }

    @Override
    public void transfer(Account from, Account to, long amount) {
        if (from.getAmount() < amount) {
            throw new IllegalStateException("Нет денег на счету" + from);
        }
        from.setAmount(from.getAmount()-amount);
        to.setAmount(to.getAmount()+amount);
    }

    @Override
    public void transferByPhoneNumber(Account from, String phoneNumber, long amount) {
        var to = phoneToAccountResolver.findAcccountByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException("Нет такого номера" + phoneNumber));

        transfer(from, to, amount);
    }
}
