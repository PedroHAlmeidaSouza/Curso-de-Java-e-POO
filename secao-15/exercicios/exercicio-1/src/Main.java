import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter a folder path (.CSV): ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Interpreta linha a linha
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                Product product = new Product(name, price, quantity);
                products.add(product);

                line = br.readLine();
            }

            // Cria o subdiretorio out e define o caminho que o arquivo será gerado
            boolean success = new File(path.getParent() + "\\out").mkdir();
            String targetFileStr = path.getParent() + "\\out\\summary.csv";

            // Cria o arquivo de saida com as informações de acordo com cada produto na lista de produtos
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr, true))) {
                for (Product product : products) {
                    bw.write(product.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
    Fazer um programa para ler o caminho de um arquivo .csv
    contendo os dados de itens vendidos. Cada item possui um
    nome, preço unitário e quantidade, separados por vírgula. Você
    deve gerar um novo arquivo chamado "summary.csv", localizado
    em uma subpasta chamada "out" a partir da pasta original do
    arquivo de origem, contendo apenas o nome e o valor total para
    aquele item (preço unitário multiplicado pela quantidade),
    conforme exemplo.
 */