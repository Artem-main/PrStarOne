package PersFinance.src.main.java.ru.productstar.servlets;

public class Transaction {
    private final String name;
    private final int amount;
    private final boolean isIncome;

    public Transaction(String name, int amount, boolean isIncome) {
        this.name = name;
        this.amount = amount;
        this.isIncome = isIncome;
    }

    public String getName() { return name; }
    public int getAmount() { return amount; }
    public boolean isIncome() { return isIncome; }

    @Override
    public String toString() {
        return "Transaction{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", isIncome=" + isIncome +
                '}';
    }
}
