import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int in = 0;
        int out = 0;

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number >= 9 && number <= 20) {
                in += 1;
            } else {
                out += 1;
            }
        }

        System.out.println("In: " + in);
        System.out.println("Out: " + out);

        sc.close();
    }
}

/*
    Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X que serão lidos em seguida.
    Mostre quantos destes valores X estão dentro do intervalo [10,20] e quantos estão fora do intervalo, mostrando
    essas informações conforme exemplo (use a palavra "in" para dentro do intervalo, e "out" para fora do intervalo).
 */