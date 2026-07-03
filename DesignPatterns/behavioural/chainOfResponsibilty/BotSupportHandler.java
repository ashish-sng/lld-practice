package DesignPatterns.behavioural.chainOfResponsibilty;

public class BotSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == Request.Priority.LOW && !request.isPaymentRelated();
    }

    @Override
    protected void process(Request request) {
        System.out.println("BotSupportHandler resolved: " + request.getIssue());
    }
}
