package SolidPrinciples.ISP.Violation;

public class RobotWorker implements Worker {
    
    @Override
    public void work() {
        System.out.println("Robot working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException(
                "Robots don't eat");
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException(
                "Robots don't sleep");
    }
}
