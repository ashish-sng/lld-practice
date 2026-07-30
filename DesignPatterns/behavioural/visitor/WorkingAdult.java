package DesignPatterns.behavioural.visitor;

public class WorkingAdult implements Person {
    private final String name;
    private final int meetingsToday;

    public WorkingAdult(String name, int meetingsToday) {
        this.name = name;
        this.meetingsToday = meetingsToday;
    }

    public String getName() {
        return name;
    }

    public int getMeetingsToday() {
        return meetingsToday;
    }

    @Override
    public void accept(PersonVisitor visitor) {
        visitor.visit(this);
    }
}
