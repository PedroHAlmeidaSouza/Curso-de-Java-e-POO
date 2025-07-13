import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        int quantity = 0;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            int x = sc.nextInt();
            if (x % 2 == 0) {
                sum++;
                quantity += x;
            }
        }

        double avg = quantity / sum;
        System.out.println();

        if (quantity == 0) {
            System.out.println("NENHUM NUMERO PAR");
        } else {
            System.out.print("MEDIA DOS PARES = " + avg);
        }

        sc.close();
    }
}

/*
    Fazer um programa para ler um vetor de N números inteiros. Em seguida, mostrar na tela a média
    aritmética somente dos números pares lidos, com uma casa decimal. Se nenhum número par for
    digitado, mostrar a mensagem "NENHUM NUMERO PAR"
 */