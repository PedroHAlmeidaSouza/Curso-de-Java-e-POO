import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String x;
        int y;
        double z;

        x = sc.next();
        y = sc.nextInt();
        z = sc.nextDouble();

//        char x;
//        x = sc.next().charAt(0);

//        String x;
//        x = sc.nextLine();

        System.out.println("Dados digitados:");
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        sc.close();
    }
}

/*
 * Para uma variável do tipo String .next()
 * Para uma variável do tipo int .nextInt()
 * Para uma variável do tipo double .nextDouble()
 * Para uma variável do tipo char .next().charAt(0)
 * Para uma variável do tipo String .nextLine()
 * */