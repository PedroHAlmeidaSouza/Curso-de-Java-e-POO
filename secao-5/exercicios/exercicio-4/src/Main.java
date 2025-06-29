import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int duracao;
        if (a < b) {
            duracao = b - a;
        } else {
            duracao = 24 - a + b;
        }

        System.out.println("O JOGO DUROU " + duracao + " HORA(S)");

        sc.close();
    }
}

/*
    Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo pode
    começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24 horas.
 */