package DesignPatterns.behavioural.chainOfResponsibilty;

public class Request {
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private final String issue;
    private final Priority priority;
    private final boolean paymentRelated;

    public Request(String issue, Priority priority, boolean paymentRelated) {
        this.issue = issue;
        this.priority = priority;
        this.paymentRelated = paymentRelated;
    }

    public String getIssue() {
        return issue;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isPaymentRelated() {
        return paymentRelated;
    }

    @Override
    public String toString() {
        return "Request{" +
                "issue='" + issue + '\'' +
                ", priority=" + priority +
                ", paymentRelated=" + paymentRelated +
                '}';
    }
}
