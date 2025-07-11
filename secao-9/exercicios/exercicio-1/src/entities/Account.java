package entities;

public class Account {

    private final static double TAX = 5.00;

    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value + TAX;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account "
                + number
                + ", Holder: "
                + holder
                + ", Balance: $ "
                + String.format("%.2f%n", balance);
    }
}
