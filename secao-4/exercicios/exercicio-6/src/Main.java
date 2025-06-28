import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = sc.nextDouble();

        int d = sc.nextInt();
        int e = sc.nextInt();
        double f = sc.nextDouble();

        double total = (b * c) + (e * f);

        System.out.printf("VALOR A PAGAR: R$ %.2f\n", total);

        sc.close();
    }
}

/*
    Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
    código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago.
 */