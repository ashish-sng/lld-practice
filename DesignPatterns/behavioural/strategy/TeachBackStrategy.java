package DesignPatterns.behavioural.strategy;

public class TeachBackStrategy implements StudyStrategy {
    @Override
    public void study(String topic) {
        System.out.println("Explaining " + topic + " aloud like teaching a friend");
    }
}
