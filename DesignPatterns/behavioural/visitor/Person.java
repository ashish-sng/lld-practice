package DesignPatterns.behavioural.visitor;

public interface Person {
    void accept(PersonVisitor visitor);
}
