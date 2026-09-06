package DesignPatterns.creational.abstract_factory;

public class MobileFactory implements UiFactory {
    @Override
    public Button createButton() {
        return new DesignPatterns.creational.abstract_factory.mobile.MobileButton();
    }

    @Override
    public Notification createNotification() {
        return new DesignPatterns.creational.abstract_factory.mobile.MobileNotification();
    }
}
