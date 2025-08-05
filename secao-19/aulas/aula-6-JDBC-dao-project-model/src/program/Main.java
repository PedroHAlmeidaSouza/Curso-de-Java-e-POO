package program;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Retorna uma instanciação da minha implementação que me da acesso as operações
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println();
        // Realizo uma busca por sellerID e retorno um objeto Seller
        System.out.println("=== TESTE 1: Seller findById ===");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println();
        // Realiza uma busca por DepartmentId
        System.out.println("=== TESTE 2: Seller findByDepartId ===");
        Department department = new Department(2, null);
        sellerDao.findByDepartment(department).forEach(System.out::println);

        System.out.println();
        // Retorna todos as Sellers e Departments associados
        System.out.println("=== TESTE 3: Seller findAll ===");
        sellerDao.findAll().forEach(System.out::println);

        System.out.println();
        // Insere um novo Saller
        System.out.println("=== TESTE 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println();
        // Atualiza um Seller
        System.out.println("=== TESTE 5: Seller update ===");
        seller = sellerDao.findById(seller.getId());
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");

    }
}
