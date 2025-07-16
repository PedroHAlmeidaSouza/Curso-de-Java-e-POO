import entities.Order;
import entities.enums.OrderStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        OrderStatus os2 = OrderStatus.DELIVERED;

        OrderStatus os3 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os2);
        System.out.println(os3);
    }
}