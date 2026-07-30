package DesignPatterns.behavioural.visitor;

public interface PersonVisitor {
    void visit(Student student);
    void visit(WorkingAdult workingAdult);
    void visit(SeniorCitizen seniorCitizen);
}
