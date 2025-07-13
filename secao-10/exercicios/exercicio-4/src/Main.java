import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        int[] vect = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("NUMEROS PARES: ");
        int quantity = 0;
        for (int i = 0; i < n; i++) {
            if (vect[i] % 2 == 0) {
                System.out.print(vect[i] + " ");
                quantity++;
            }
        }

        System.out.println();
        System.out.println("\nQUANTIDADE DE PARES = " + quantity);

        sc.close();
    }
}

/*
    Faça um programa que leia N números inteiros e armazene-os em um vetor. Em seguida, mostre na
    tela todos os números pares, e também a quantidade de números pares.
 */