package DesignPatterns.behavioural.state;

public class FocusSession {
    private FocusState currentState;
    private final String topic;

    public FocusSession(String topic) {
        this.topic = topic;
        this.currentState = new FreshState();
    }

    public void setState(FocusState currentState) {
        this.currentState = currentState;
    }

    public String getTopic() {
        return topic;
    }

    public void study() {
        System.out.println("Current state: " + currentState.getName());
        currentState.study(this);
    }
}
