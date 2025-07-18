import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<Product>();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Product #" + i + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            } else if (ch == 'u') {
                System.out.print("Manufacture date: ");
                sc.nextLine();
                String manufactureDate = sc.nextLine();
                products.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));
            } else if (ch == 'c') {
                products.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}

/*
    Fazer um programa para ler os dados de N
    produtos (N fornecido pelo usuário). Ao final,
    mostrar a etiqueta de preço de cada produto na
    mesma ordem em que foram digitados.
    Todo produto possui nome e preço. Produtos
    importados possuem uma taxa de alfândega, e
    produtos usados possuem data de fabricação.
    Estes dados específicos devem ser
    acrescentados na etiqueta de preço conforme
    exemplo (próxima página). Para produtos
    importados, a taxa e alfândega deve ser
    acrescentada ao preço final do produto.
    Favor implementar o programa conforme
    projeto ao lado.
 */