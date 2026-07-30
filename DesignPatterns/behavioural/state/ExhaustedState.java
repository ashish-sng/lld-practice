package DesignPatterns.behavioural.state;

public class ExhaustedState implements FocusState {
    @Override
    public void study(FocusSession session) {
        System.out.println("Energy is low. Taking a break before continuing " + session.getTopic());
        session.setState(new FreshState());
    }

    @Override
    public String getName() {
        return "Exhausted";
    }
}
