package program;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");

        Seller obj2 = new Seller(1, "Pedro", "pedro@gmail.com", new Date(), 3000.0, obj);

        System.out.println(obj);
        System.out.println(obj2);
    }
}