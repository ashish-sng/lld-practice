package DesignPatterns.behavioural.strategy;

public class EveningStudySession {
    private StudyStrategy studyStrategy;

    public EveningStudySession(StudyStrategy studyStrategy) {
        this.studyStrategy = studyStrategy;
    }

    public void setStudyStrategy(StudyStrategy studyStrategy) {
        this.studyStrategy = studyStrategy;
    }

    public void startSession(String topic) {
        if (studyStrategy == null) {
            System.out.println("No study strategy selected for " + topic);
            return;
        }

        studyStrategy.study(topic);
    }
}
