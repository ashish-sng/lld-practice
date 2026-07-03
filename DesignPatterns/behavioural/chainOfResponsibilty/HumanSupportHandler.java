package DesignPatterns.behavioural.chainOfResponsibilty;

public class HumanSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == Request.Priority.MEDIUM;
    }

    @Override
    protected void process(Request request) {
        System.out.println("HumanSupportHandler resolved: " + request.getIssue());
    }
}
