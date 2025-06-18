package SpringFramework;

public class Account {

    private final long id;
    private long amount;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }

    public long getId() {
        return id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Account(long id, long amount) {
        this.id = id;
        this.amount = amount;
    }
}
