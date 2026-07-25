package DesignPatterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

public class WeekendPlan {
    private final List<Activity> activities = new ArrayList<>();

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public ActivityIterator createIterator() {
        return new WeekendPlanIterator(activities);
    }
}
