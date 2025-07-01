import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (b == 0) {
                System.out.println("Divisao impossivel!");
            } else {
                double calculo = (double) a / b;
                System.out.println(calculo);
            }
        }

        sc.close();
    }
}

/*
    Fazer um programa para ler um número N. Depois leia N pares de números e mostre a divisão do primeiro pelo
    segundo. Se o denominador for igual a zero, mostrar a mensagem "divisao impossivel".
 */