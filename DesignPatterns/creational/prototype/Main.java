package DesignPatterns.creational.prototype;

public class Main {
    public static void main(String[] args) {
        HumanWorker originalHuman = new HumanWorker("Aman", "Backend Development", 4);
        HumanWorker clonedHuman = originalHuman.cloneWorker();
        clonedHuman.setName("Priya");
        clonedHuman.setExperienceYears(2);

        RobotWorker originalRobot = new RobotWorker("RX-101", "Warehouse Packaging", 90);
        RobotWorker clonedRobot = originalRobot.cloneWorker();
        clonedRobot.setModel("RX-102");
        clonedRobot.setBatteryLevel(75);

        System.out.println("Original human: " + originalHuman);
        System.out.println("Cloned human: " + clonedHuman);
        originalHuman.work();
        clonedHuman.work();

        System.out.println();

        System.out.println("Original robot: " + originalRobot);
        System.out.println("Cloned robot: " + clonedRobot);
        originalRobot.work();
        clonedRobot.work();
    }
}
