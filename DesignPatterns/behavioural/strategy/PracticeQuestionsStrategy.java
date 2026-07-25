package DesignPatterns.behavioural.strategy;

public class PracticeQuestionsStrategy implements StudyStrategy {
    @Override
    public void study(String topic) {
        System.out.println("Solving practice questions for " + topic);
    }
}
