import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        List<Object> myObjs = new ArrayList<Object>();
//        List<Integer> myNumbers = new ArrayList<Integer>();
//        myObjs = myNumbers; // erro de compilação

        List<Integer> myInts = Arrays.asList(1, 2, 3);
        printList(myInts);
        List<String> myStrs = Arrays.asList("a", "b", "c");
        printList(myStrs);
    }

    public static void printList(List<?> list) { // Caso troque para List<Object> no parâmetro não seria possível fazer o upcasting de List<Integer> para List<Object>
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}