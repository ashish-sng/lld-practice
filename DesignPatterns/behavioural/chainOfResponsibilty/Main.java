package DesignPatterns.behavioural.chainOfResponsibilty;

public class Main {
    public static void main(String[] args) {
        SupportHandler botSupportHandler = new BotSupportHandler();
        SupportHandler humanSupportHandler = new HumanSupportHandler();
        SupportHandler billingSupportHandler = new BillingSupportHandler();
        SupportHandler managerSupportHandler = new ManagerSupportHandler();

        botSupportHandler
                .setNextHandler(humanSupportHandler)
                .setNextHandler(billingSupportHandler)
                .setNextHandler(managerSupportHandler);

        Request passwordReset = new Request(
                "Need help resetting password",
                Request.Priority.LOW,
                false
        );

        Request refundRequest = new Request(
                "Refund not credited",
                Request.Priority.MEDIUM,
                true
        );

        Request securityIssue = new Request(
                "Suspicious activity on account",
                Request.Priority.HIGH,
                false
        );

        botSupportHandler.handle(passwordReset);
        botSupportHandler.handle(refundRequest);
        botSupportHandler.handle(securityIssue);
    }
}
