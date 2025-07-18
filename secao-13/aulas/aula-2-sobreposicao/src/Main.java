import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withDraw(200.0);
        System.out.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc2.withDraw(200.0);
        System.out.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc3.withDraw(200.0);
        System.out.println(acc3.getBalance());
    }
}

/*
    Suponha um negócio de banco que possui uma conta comum e uma conta para
    empresas, sendo que a conta para empresa possui todos membros da conta
    comum, mais um limite de empréstimo e uma operação de realizar empréstimo.
 */