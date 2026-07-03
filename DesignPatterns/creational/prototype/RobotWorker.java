package DesignPatterns.creational.prototype;

public class RobotWorker implements Worker {
    private String model;
    private String taskType;
    private int batteryLevel;

    public RobotWorker(String model, String taskType, int batteryLevel) {
        this.model = model;
        this.taskType = taskType;
        this.batteryLevel = batteryLevel;
    }

    public RobotWorker(RobotWorker other) {
        this.model = other.model;
        this.taskType = other.taskType;
        this.batteryLevel = other.batteryLevel;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public RobotWorker cloneWorker() {
        return new RobotWorker(this);
    }

    @Override
    public void work() {
        System.out.println(model + " is executing " + taskType + ".");
    }

    @Override
    public String toString() {
        return "RobotWorker{" +
                "model='" + model + '\'' +
                ", taskType='" + taskType + '\'' +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
