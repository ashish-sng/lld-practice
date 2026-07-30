package DesignPatterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

public class FamilyTripGroup implements TripMediator {
    private final List<FamilyMember> members = new ArrayList<>();

    public void addMember(FamilyMember familyMember) {
        members.add(familyMember);
    }

    @Override
    public void sendUpdate(String message, FamilyMember sender) {
        for (FamilyMember member : members) {
            if (member != sender) {
                member.receive(sender.getName() + ": " + message);
            }
        }
    }
}
