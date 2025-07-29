import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        System.out.print("How many students for course A? ");
        int studentsA = sc.nextInt();
        for (int i = 0; i < studentsA; i++) {
            a.add(sc.nextInt());
        }

        System.out.print("How many students for course B? ");
        int studentsB = sc.nextInt();
        for (int i = 0; i < studentsB; i++) {
            b.add(sc.nextInt());
        }

        System.out.print("How many students for course C? ");
        int studentsC = sc.nextInt();
        for (int i = 0; i < studentsC; i++) {
            c.add(sc.nextInt());
        }

        Set<Integer> total = new HashSet<>(a);
        total.addAll(b);
        total.addAll(c);

        System.out.println("Total students: " + total.size());

        sc.close();
    }
}

/*
    Em um portal de cursos online, cada usuário possui um código único, representado por
    um número inteiro.
    Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se
    matricular em quantos cursos quiser. Assim, o número total de alunos de um instrutor não
    é simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
    alunos repetidos em mais de um curso.
    O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
    Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
    quantidade total e alunos dele, conforme exemplo.
 */