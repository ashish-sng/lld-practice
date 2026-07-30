package DesignPatterns.behavioural.visitor;

public class Student implements Person {
    private final String name;
    private final int studyHoursToday;

    public Student(String name, int studyHoursToday) {
        this.name = name;
        this.studyHoursToday = studyHoursToday;
    }

    public String getName() {
        return name;
    }

    public int getStudyHoursToday() {
        return studyHoursToday;
    }

    @Override
    public void accept(PersonVisitor visitor) {
        visitor.visit(this);
    }
}
