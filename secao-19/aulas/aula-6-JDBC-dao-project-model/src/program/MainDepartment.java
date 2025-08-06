package program;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.Scanner;

public class MainDepartment {
    public static void main(String[] args) {

        // Retorna uma instanciação da minha implementação que me da acesso às operações
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println();
        // Realizo uma busca por departmentId e retorno um objeto Department
        System.out.println("=== TESTE 1: Department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println();
        // Realiza uma busca por SellerId
        System.out.println("=== TESTE 2: Department findBySellerId ===");
        Seller seller = new Seller(4, null, null, null, null, null);
        departmentDao.findBySeller(seller).forEach(System.out::println);

        System.out.println();
        // Retorna todos as Departments
        System.out.println("=== TESTE 3: Department findAll ===");
        departmentDao.findAll().forEach(System.out::println);

        System.out.println();
        // Insere um novo Department
        System.out.println("=== TESTE 4: Department insert ===");
        Department newDepartment = new Department(null, "IT");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println();
        // Atualiza um Department
        System.out.println("=== TESTE 5: Department update ===");
        department = departmentDao.findById(department.getId());
        department.setName("Martha Waine");
        departmentDao.update(department);
        System.out.println("Update completed!");

        Scanner sc = new Scanner(System.in);

        System.out.println();
        // Deleta um Department
        System.out.println("=== TESTE 6: Department delete ===");
        System.out.print("Enter the department id to be deleted: ");
        departmentDao.deleteById(sc.nextInt());
        System.out.println("Delete completed!");

        sc.close();
    }
}
