import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> stream = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(stream.toArray()));

        // Soma todos os elementos da lista usando reduce, começando do zero e acumulando a soma.
        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);

        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .collect(java.util.stream.Collectors.toList());

        // O pipeline pega a list, filtra somente os números pares e multiplica cada um por 10
        System.out.println(Arrays.toString(newList.toArray()));
    }
}