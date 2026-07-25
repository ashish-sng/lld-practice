package DesignPatterns.behavioural.command;

public class StartFanCommand implements Command {
    private final Fan fan;

    public StartFanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.start();
    }

    @Override
    public void undo() {
        fan.stop();
    }
}
