import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.50));

        Comparator<Product> comparator = (o1, p2) -> {
            return o1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        };

        list.sort(comparator);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}