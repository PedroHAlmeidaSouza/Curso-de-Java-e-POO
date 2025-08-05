package program;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Main {
    public static void main(String[] args) {

        // Retorna uma instanciação da minha implementação que me da acesso as operações
        SellerDao sellerDao = DaoFactory.createSellerDao();

        // Realizo uma busca por ID e retorno um objeto Seller
        System.out.println("=== TESTE 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
