import entities.People;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas voce vai digitar? ");
        int n = sc.nextInt();

        People[] people = new People[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Idade: ");
            int age = sc.nextInt();

            people[i] = new People(name, age);
        }

        String oldestName = people[0].getName();
        int oldestAge = people[0].getAge();

        for (int i = 1; i < n; i++) {
            if (people[i].getAge() > oldestAge) {
                oldestAge = people[i].getAge();
                oldestName = people[i].getName();
            }
        }

        System.out.println();
        System.out.println("PESSOA MAIS VELHA: " + oldestName);

        sc.close();
    }
}

/*
    Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas idades. Os nomes
    devem ser armazenados em um vetor, e as idades em um outro vetor. Depois, mostrar na tela o nome
    da pessoa mais velha.
 */