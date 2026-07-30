package DesignPatterns.behavioural.visitor;

public class Main {
    public static void main(String[] args) {
        Person[] familyMembers = {
                new Student("Anaya", 3),
                new WorkingAdult("Rohit", 7),
                new SeniorCitizen("Dadi", 25)
        };

        PersonVisitor wellnessVisitor = new DailyWellnessVisitor();
        PersonVisitor supportSuggestionVisitor = new SupportSuggestionVisitor();

        System.out.println("Daily wellness summary:");
        for (Person familyMember : familyMembers) {
            familyMember.accept(wellnessVisitor);
        }

        System.out.println("Support suggestions:");
        for (Person familyMember : familyMembers) {
            familyMember.accept(supportSuggestionVisitor);
        }
    }
}
