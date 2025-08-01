import entities.Product;
import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        String path = "C:\\Users\\Pedro Henrique\\Documents\\Estudos\\Curso-de-Java-e-POO\\secao-17\\aulas\\aula-2-genericos-delimitados\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product x = CalculationService.max(list);
            System.out.println("Most expensive product: ");
            System.out.println(x);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
    Uma empresa de consultoria deseja avaliar a performance de produtos,
    funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
    o maior dentre um conjunto de elementos. Fazer um programa que leia um
    conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
    mostre o mais caro deles.
 */