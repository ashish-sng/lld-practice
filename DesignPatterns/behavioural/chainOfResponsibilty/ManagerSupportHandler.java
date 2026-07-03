package DesignPatterns.behavioural.chainOfResponsibilty;

public class ManagerSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == Request.Priority.HIGH;
    }

    @Override
    protected void process(Request request) {
        System.out.println("ManagerSupportHandler escalated and resolved: " + request.getIssue());
    }
}
