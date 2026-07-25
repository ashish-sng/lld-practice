package DesignPatterns.behavioural.command;

public class StopFanCommand implements Command {
    private final Fan fan;

    public StopFanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stop();
    }

    @Override
    public void undo() {
        fan.start();
    }
}
