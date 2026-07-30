package DesignPatterns.behavioural.state;

public class Main {
    public static void main(String[] args) {
        FocusSession focusSession = new FocusSession("System Design");

        focusSession.study();
        focusSession.study();
        focusSession.study();
        focusSession.study();
    }
}
