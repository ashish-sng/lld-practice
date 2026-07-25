package DesignPatterns.behavioural.command;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        Command turnOnLightCommand = new TurnOnLightCommand(light);
        Command turnOffLightCommand = new TurnOffLightCommand(light);
        Command startFanCommand = new StartFanCommand(fan);
        Command stopFanCommand = new StopFanCommand(fan);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.submit(turnOnLightCommand);
        remoteControl.pressUndo();

        remoteControl.submit(startFanCommand);
        remoteControl.pressUndo();

        remoteControl.submit(turnOffLightCommand);
        remoteControl.pressUndo();

        remoteControl.submit(stopFanCommand);
        remoteControl.pressUndo();
    }
}
