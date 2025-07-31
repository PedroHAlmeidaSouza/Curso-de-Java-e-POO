import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        Predicate<Product> predicate = p -> p.getPrice() >= 100.00;

        list.removeIf(predicate);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}

/*
    Fazer um programa que, a partir de uma lista de produtos, remova da
    lista somente aqueles cujo preço mínimo seja 100.
 */