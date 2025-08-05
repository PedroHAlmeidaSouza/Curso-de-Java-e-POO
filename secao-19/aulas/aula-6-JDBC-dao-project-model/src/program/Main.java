package program;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Retorna uma instanciação da minha implementação que me da acesso as operações
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println();
        // Realizo uma busca por sellerID e retorno um objeto Seller
        System.out.println("=== TESTE 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();
        // Realiza uma busca por DepartmentId
        System.out.println("=== TESTE 2: Seller findByDepartId ===");
        Department department = new Department(2, null);
        sellerDao.findByDepartment(department).forEach(System.out::println);

        System.out.println();
        // Retorna todos as Sellers e Departments associ
        System.out.println("=== TESTE 3: Seller findAll ===");
        sellerDao.findAll().forEach(System.out::println);

    }
}
