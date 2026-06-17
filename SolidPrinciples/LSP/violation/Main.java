package SolidPrinciples.LSP.violation;

public class Main {

    public static void main(String[] args) {

        Rectangle rectangle = new Square();

        rectangle.setWidth(5);
        rectangle.setHeight(10);

        System.out.println(rectangle.getArea());
    }
}
