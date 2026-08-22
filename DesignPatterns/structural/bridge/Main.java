package DesignPatterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        AlertChannel slackChannel = new SlackAlertChannel();
        AlertChannel pagerDutyChannel = new PagerDutyAlertChannel();

        Alert criticalAlert = new SecurityAlert(slackChannel);
        criticalAlert.notify("CriticalService", "Critical issue occurred!");

        Alert pagerDutySecurityAlert = new SecurityAlert(pagerDutyChannel);
        pagerDutySecurityAlert.notify("auth-service", "Multiple failed login attempts");
    }
}
