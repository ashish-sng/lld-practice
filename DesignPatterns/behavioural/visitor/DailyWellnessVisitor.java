package DesignPatterns.behavioural.visitor;

public class DailyWellnessVisitor implements PersonVisitor {
    @Override
    public void visit(Student student) {
        System.out.println(student.getName() + " studied for " + student.getStudyHoursToday()
                + " hours today.");
    }

    @Override
    public void visit(WorkingAdult workingAdult) {
        System.out.println(workingAdult.getName() + " attended " + workingAdult.getMeetingsToday()
                + " meetings today.");
    }

    @Override
    public void visit(SeniorCitizen seniorCitizen) {
        System.out.println(seniorCitizen.getName() + " walked for " + seniorCitizen.getWalkMinutesToday()
                + " minutes today.");
    }
}
