package java_playground.initialization_block;
// The order is like: Static block then instance block then constructor for initialization blocks!
public class Block {
    static String firstName = "Ashish";
    String lastName = "Singh";

    static {
        System.out.println("Name: " + firstName);
    }
    static {
        System.out.println("Hello " + firstName);
    }

    {
        System.out.println("Last Name: " + lastName);
    }
    {
        System.out.println("Hellloi ");
    }
    {
        System.out.println("World!!!! ");
    }

    public Block() {
        System.out.println("Block Constructor");
    }
}
