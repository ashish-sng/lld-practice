package DesignPatterns.behavioural.mediator;

public class Main {
    public static void main(String[] args) {
        FamilyTripGroup familyTripGroup = new FamilyTripGroup();

        FamilyMember mother = new Parent(familyTripGroup, "Mother");
        FamilyMember father = new Parent(familyTripGroup, "Father");
        FamilyMember sister = new Sibling(familyTripGroup, "Sister");
        FamilyMember brother = new Sibling(familyTripGroup, "Brother");

        familyTripGroup.addMember(mother);
        familyTripGroup.addMember(father);
        familyTripGroup.addMember(sister);
        familyTripGroup.addMember(brother);

        mother.send("Train tickets are booked for Saturday morning.");
        sister.send("I will handle snacks for the trip.");
        father.send("Please be ready by 6 AM.");
    }
}
