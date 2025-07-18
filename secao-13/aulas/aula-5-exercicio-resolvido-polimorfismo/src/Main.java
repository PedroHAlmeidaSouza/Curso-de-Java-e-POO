import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<Employee>();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharges = sc.nextDouble();
                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharges));
            } else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - $ " + String.format("%.2f", employee.payment()));
        }

        sc.close();
    }
}

/*
    Uma empresa possui funcionários próprios e terceirizados.
    Para cada funcionário, deseja-se registrar nome, horas
    trabalhadas e valor por hora. Funcionários terceirizado
    possuem ainda uma despesa adicional.
    O pagamento dos funcionários corresponde ao valor da hora
    multiplicado pelas horas trabalhadas, sendo que os
    funcionários terceirizados ainda recebem um bônus
    correspondente a 110% de sua despesa adicional.
    Fazer um programa para ler os dados de N funcionários (N
    fornecido pelo usuário) e armazená-los em uma lista. Depois
    de ler todos os dados, mostrar nome e pagamento de cada
    funcionário na mesma ordem em que foram digitados.
    Construa o programa conforme projeto ao lado. Veja
    exemplo na próxima página.
 */