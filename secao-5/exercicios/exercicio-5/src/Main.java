import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        double cachorroQuente = 4.00;
        double xSalada = 4.50;
        double xBacon = 5.00;
        double torradaSimples = 2.00;
        double refrigerante = 1.50;

        int codigo = sc.nextInt();
        int quantidade = sc.nextInt();

        double total;
        if (codigo == 1) {
            total = quantidade * cachorroQuente;
        } else if (codigo == 2) {
            total = quantidade * xSalada;
        } else if (codigo == 3) {
            total = quantidade * xBacon;
        } else if (codigo == 4) {
            total = quantidade * torradaSimples;
        } else {
            total = quantidade * refrigerante;
        }

        System.out.printf("Total: R$ %.2f\n", total);

        sc.close();
    }
}

/*
    Com base na tabela abaixo, escreva um programa que leia o código de um item e a quantidade deste item. A
    seguir, calcule e mostre o valor da conta a pagar.
 */