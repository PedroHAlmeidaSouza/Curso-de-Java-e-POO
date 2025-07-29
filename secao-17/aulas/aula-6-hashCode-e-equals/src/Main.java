import entities.Client;

public class Main {
    public static void main(String[] args) {
        String a = "Maria";
        String b = "Alex";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println("-------------------------------------");

        Client c1 = new Client("Maria", "maria@gmail.com");
        Client c2 = new Client("Maria", "alex@gmail.com");

        String s1 = "test";
        String s2 = "test";

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2); // False, pois tem referências de memória diferentes
        System.out.println(s1 == s2); // True, pois o compilador tem um tratamento especial para expressões literais
    }
}