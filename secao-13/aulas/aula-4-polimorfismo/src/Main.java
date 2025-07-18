import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0);
    }
}

/*
    Suponha um negócio de banco que possui uma conta comum e uma conta para
    empresas, sendo que a conta para empresa possui todos membros da conta
    comum, mais um limite de empréstimo e uma operação de realizar empréstimo.
 */