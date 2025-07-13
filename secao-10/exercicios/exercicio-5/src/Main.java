import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        double[] vect = new double[n];

        double greaterValue = 0.0;
        int position = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
            if (vect[i] > greaterValue) {
                greaterValue = vect[i];
                position = i;
            }
        }

        System.out.println();
        System.out.printf("MAIOR VALOR = %.1f%n", greaterValue);
        System.out.println("POSICAO DO MAIOR VALOR = " + position);

        sc.close();
    }
}

/*
    Faça um programa que leia N números reais e armazene-os em um vetor. Em seguida, mostrar na tela
    o maior número do vetor (supor não haver empates). Mostrar também a posição do maior elemento,
    considerando a primeira posição como 0 (zero).
 */