import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("Email: ");
        String clientEmail = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(sc.nextLine());

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Enter #" + i + " item data:");

            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(quantity, price, new Product(productName, price));
            order.addItem(item);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        sc.close();
    }
}

/*
    Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
    sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
    o instante do sistema: new Date()
 */