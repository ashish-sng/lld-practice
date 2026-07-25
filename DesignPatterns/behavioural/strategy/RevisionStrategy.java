package DesignPatterns.behavioural.strategy;

public class RevisionStrategy implements StudyStrategy {
    @Override
    public void study(String topic) {
        System.out.println("Revising notes and key formulas for " + topic);
    }
}
