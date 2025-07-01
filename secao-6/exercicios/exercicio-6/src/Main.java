import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            double valor1 = sc.nextDouble();
            double valor2 = sc.nextDouble();
            double valor3 = sc.nextDouble();

            int peso1 = 2;
            int peso2 = 3;
            int peso3 = 5;

            double media = (valor1 * peso1 + valor2 * peso2 + valor3 * peso3) / (peso1 + peso2 + peso3);

            System.out.printf("%.1f%n", media);
        }

        sc.close();
    }
}

/*
    Leia 1 valor inteiro N, que representa o número de casos de teste que vem a seguir. Cada caso de teste consiste
    de 3 valores reais, cada um deles com uma casa decimal. Apresente a média ponderada para cada um destes
    conjuntos de 3 valores, sendo que o primeiro valor tem peso 2, o segundo valor tem peso 3 e o terceiro valor tem
    peso 5.
 */