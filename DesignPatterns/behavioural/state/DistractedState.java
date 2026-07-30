package DesignPatterns.behavioural.state;

public class DistractedState implements FocusState {
    @Override
    public void study(FocusSession session) {
        System.out.println("Attention is drifting. Switching to short tasks for " + session.getTopic());
        session.setState(new ExhaustedState());
    }

    @Override
    public String getName() {
        return "Distracted";
    }
}
