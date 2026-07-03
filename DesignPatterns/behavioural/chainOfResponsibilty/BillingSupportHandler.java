package DesignPatterns.behavioural.chainOfResponsibilty;

public class BillingSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(Request request) {
        return request.isPaymentRelated();
    }

    @Override
    protected void process(Request request) {
        System.out.println("BillingSupportHandler resolved payment issue: " + request.getIssue());
    }
}
