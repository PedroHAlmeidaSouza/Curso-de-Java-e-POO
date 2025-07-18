import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Integer[][] mat = new Integer[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (mat[i][j] == x) {
                    System.out.println("Position " + i + "," + j + ":");
                    if (j > 0) {
                        System.out.println("Left: " + mat[i][j-1]);
                    }
                    if (i > 0) {
                        System.out.println("Up: " + mat[i-1][j]);
                    }
                    if (j < mat[i].length-1) {
                        System.out.println("Right: " + mat[i][j+1]);
                    }
                    if (i < mat.length-1) {
                        System.out.println("Down: " + mat[i+1][j]);
                    }
                }
            }
        }

        sc.close();
    }
}

/*
    Fazer um programa para ler dois números inteiros M e N, e depois ler
    uma matriz de M linhas por N colunas contendo números inteiros,
    podendo haver repetições. Em seguida, ler um número inteiro X que
    pertence à matriz. Para cada ocorrência de X, mostrar os valores à
    esquerda, acima, à direita e abaixo de X, quando houver, conforme
    exemplo.
 */