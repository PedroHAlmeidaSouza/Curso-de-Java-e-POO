import entities.People;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();

        People[] vect = new People[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa:");

            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            vect[i] = new People(nome, idade, altura);
        }

        double sum = 0.0;
        int peopleUnderSixten = 0;
        for (int i = 0; i < n; i++) {
            sum += vect[i].getHeight();
            if (vect[i].getAge() < 16) {
                peopleUnderSixten++;
            }
        }

        double percentagePeopleUnderSixten = (double) peopleUnderSixten / n * 100;
        double avg = sum / n;

        System.out.printf("%nAltura média: %.2f%n", avg);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentagePeopleUnderSixten);

        for (int i = 0; i < n; i++) {
            if (vect[i].getAge() < 16) {
                System.out.println(vect[i].getName());
            }
        }

        sc.close();
    }
}

/*
    Fazer um programa para ler nome, idade e altura de N pessoas, conforme exemplo. Depois, mostrar na
    tela a altura média das pessoas, e mostrar também a porcentagem de pessoas com menos de 16 anos,
    bem como os nomes dessas pessoas caso houver.
 */