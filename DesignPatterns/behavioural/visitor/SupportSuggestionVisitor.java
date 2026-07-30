package DesignPatterns.behavioural.visitor;

public class SupportSuggestionVisitor implements PersonVisitor {
    @Override
    public void visit(Student student) {
        if (student.getStudyHoursToday() < 2) {
            System.out.println("Suggestion for " + student.getName()
                    + ": create a quiet 30-minute study block tonight.");
            return;
        }
        System.out.println("Suggestion for " + student.getName()
                + ": keep the same study rhythm tomorrow.");
    }

    @Override
    public void visit(WorkingAdult workingAdult) {
        if (workingAdult.getMeetingsToday() > 5) {
            System.out.println("Suggestion for " + workingAdult.getName()
                    + ": block focus time tomorrow morning.");
            return;
        }
        System.out.println("Suggestion for " + workingAdult.getName()
                + ": your schedule looks balanced today.");
    }

    @Override
    public void visit(SeniorCitizen seniorCitizen) {
        if (seniorCitizen.getWalkMinutesToday() < 20) {
            System.out.println("Suggestion for " + seniorCitizen.getName()
                    + ": take a light evening walk if comfortable.");
            return;
        }
        System.out.println("Suggestion for " + seniorCitizen.getName()
                + ": great job staying active today.");
    }
}
