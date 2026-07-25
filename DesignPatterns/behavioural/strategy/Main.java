package DesignPatterns.behavioural.strategy;

public class Main {
    public static void main(String[] args) {
        EveningStudySession studySession = new EveningStudySession(new RevisionStrategy());

        System.out.println("Low energy after college:");
        studySession.startSession("Operating Systems");

        System.out.println("Feeling sharp before a test:");
        studySession.setStudyStrategy(new PracticeQuestionsStrategy());
        studySession.startSession("Dynamic Programming");

        System.out.println("Want to check true understanding:");
        studySession.setStudyStrategy(new TeachBackStrategy());
        studySession.startSession("Computer Networks");
    }
}
