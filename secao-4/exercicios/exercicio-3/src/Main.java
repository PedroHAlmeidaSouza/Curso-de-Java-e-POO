import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double pi = 3.14159;

        double raio = sc.nextDouble();

        double area = pi * Math.pow(raio, 2.0);

        System.out.printf("A = %.4f%n", area);

        sc.close();

    }
}

/*
    Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
    casas decimais conforme exemplos.
 */