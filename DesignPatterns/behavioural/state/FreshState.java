package DesignPatterns.behavioural.state;

public class FreshState implements FocusState {
    @Override
    public void study(FocusSession session) {
        System.out.println("Mind is fresh. Deep work starts on " + session.getTopic());
        session.setState(new DistractedState());
    }

    @Override
    public String getName() {
        return "Fresh";
    }
}
