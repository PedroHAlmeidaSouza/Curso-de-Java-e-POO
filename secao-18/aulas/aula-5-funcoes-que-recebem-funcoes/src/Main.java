import entities.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, p -> p.getName().startsWith("T"));

        System.out.println("Sum = " + String.format("%.2f", sum));

    }
}

/*
    Fazer um programa que, a partir de uma lista de produtos, calcule a
    soma dos preços somente dos produtos cujo nome começa com "T".
 */