package DesignPatterns.behavioural.iterator;

import java.util.List;

public class WeekendPlanIterator implements ActivityIterator {
    private final List<Activity> activities;
    private int index;

    public WeekendPlanIterator(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public boolean hasNext() {
        while (index < activities.size() && activities.get(index).isCancelled()) {
            index++;
        }
        return index < activities.size();
    }

    @Override
    public Activity next() {
        if (!hasNext()) {
            return null;
        }
        return activities.get(index++);
    }
}
