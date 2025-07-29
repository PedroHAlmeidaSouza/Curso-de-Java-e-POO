import entities.Circle;
import entities.Rectangle;
import entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(myCircles));
    }

    // public static double totalArea(List<Shape> list) { Caso a lista passada por parâmetro seja do tipo Circle, dara erro, pois List<Shape> não é um supertipo de List<Circe>
    public static double totalArea(List<? extends Shape> list) { // Dessa maneira eu deixo explicito que essa lista pode ser de Shape ou qualquer subtipo de Shape
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}