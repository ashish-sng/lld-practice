package DesignPatterns.behavioural.iterator;

public class Activity {
    private final String title;
    private final String timeSlot;
    private final boolean cancelled;

    public Activity(String title, String timeSlot, boolean cancelled) {
        this.title = title;
        this.timeSlot = timeSlot;
        this.cancelled = cancelled;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return timeSlot + " - " + title + (cancelled ? " (cancelled)" : "");
    }
}
