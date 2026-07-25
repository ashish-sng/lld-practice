package DesignPatterns.behavioural.command;

public class RemoteControl {
    private Command lastCommand;

    public void submit(Command command) {
        command.execute();
        lastCommand = command;
    }

    public void pressUndo() {
        if (lastCommand == null) {
            System.out.println("No command available to undo");
            return;
        }

        lastCommand.undo();
    }
}
