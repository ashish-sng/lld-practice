package DesignPatterns.behavioural.state;

public interface FocusState {
    void study(FocusSession session);
    String getName();
}
