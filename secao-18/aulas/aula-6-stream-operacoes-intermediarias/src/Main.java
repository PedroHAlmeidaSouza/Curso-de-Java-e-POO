import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Cria uma stream a partir de uma lista (coleção) e transforma os elementos com map.
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // Cria uma stream diretamente a partir de valores literais (Stream.of(...)), sem lista ou array intermediário.
        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        // Cria uma stream com números pares, começando do zero, usando Stream.iterate.
        //A stream é infinita, mas é limitada aos 10 primeiros valores com .limit(10), e então os elementos são convertidos em array para exibição.
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        // Cria uma stream com os 10 primeiros números da sequência de Fibonacci, gerando pares e mapeando apenas o primeiro valor de cada par para formar a sequência.
        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));
    }
}