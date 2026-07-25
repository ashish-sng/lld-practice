package DesignPatterns.behavioural.iterator;

public class Main {
    public static void main(String[] args) {
        WeekendPlan weekendPlan = new WeekendPlan();

        weekendPlan.addActivity(new Activity("Morning walk with dad", "Saturday 7 AM", false));
        weekendPlan.addActivity(new Activity("Coffee catch-up with a school friend", "Saturday 5 PM", false));
        weekendPlan.addActivity(new Activity("Dentist appointment", "Sunday 10 AM", true));
        weekendPlan.addActivity(new Activity("Cook dinner with siblings", "Sunday 8 PM", false));

        ActivityIterator iterator = weekendPlan.createIterator();

        System.out.println("Weekend plan:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
