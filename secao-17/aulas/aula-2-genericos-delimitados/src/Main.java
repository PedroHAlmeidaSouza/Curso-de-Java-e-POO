import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        String path = "C:\\Users\\Pedro Henrique\\Documents\\Estudos\\Curso-de-Java-e-POO\\secao-17\\aulas\\aula-2-genericos-delimitados\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                list.add(Integer.parseInt(line));
                line = br.readLine();
            }

            Integer x = CalculationService.max(list);
            System.out.println("Max: ");
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