import entities.Account;
import exceptions.InsufficientBalanceException;
import exceptions.WithdrawLimitExceededException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();

        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();

        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        } catch (InsufficientBalanceException | WithdrawLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

/*
    Fazer um programa para ler os dados de uma conta bancária e depois realizar um
    saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
    ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
    saque da conta. Implemente a conta bancária conforme projeto abaixo:
 */