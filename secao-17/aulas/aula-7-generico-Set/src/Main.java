import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(); // Não mantém a ordem

        hashSet.add("TV");
        hashSet.add("Tablet");
        hashSet.add("Notebook");

        System.out.println(hashSet.contains("Notebook"));

        for (String p : hashSet) {
            System.out.println(p);
        }

        System.out.println("--------------------------------------");

        Set<String> treeSet = new TreeSet<>(); // Ordena os dados

        treeSet.add("TV");
        treeSet.add("Tablet");
        treeSet.add("Notebook");

        System.out.println(treeSet.contains("Notebook"));

        for (String p : treeSet) {
            System.out.println(p);
        }

        System.out.println("--------------------------------------");

        Set<String> linkedHashSet = new LinkedHashSet<>(); // Manteve a ordem em que os elementos foram inseridos

        linkedHashSet.add("TV");
        linkedHashSet.add("Tablet");
        linkedHashSet.add("Notebook");

        System.out.println(linkedHashSet.contains("Notebook"));

        for (String p : linkedHashSet) {
            System.out.println(p);
        }
    }
}