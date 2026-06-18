package SolidPrinciples.ISP.correct;

public class RobotWorker implements Workable {
    
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
