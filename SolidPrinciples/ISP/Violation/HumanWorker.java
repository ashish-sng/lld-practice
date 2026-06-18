package SolidPrinciples.ISP.Violation;

public class HumanWorker implements Worker {

    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }

    // @Override
    public void sleep() {
        System.out.println("Human sleeping");
    }
}
