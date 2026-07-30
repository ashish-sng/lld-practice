package DesignPatterns.behavioural.visitor;

public class SeniorCitizen implements Person {
    private final String name;
    private final int walkMinutesToday;

    public SeniorCitizen(String name, int walkMinutesToday) {
        this.name = name;
        this.walkMinutesToday = walkMinutesToday;
    }

    public String getName() {
        return name;
    }

    public int getWalkMinutesToday() {
        return walkMinutesToday;
    }

    @Override
    public void accept(PersonVisitor visitor) {
        visitor.visit(this);
    }
}
