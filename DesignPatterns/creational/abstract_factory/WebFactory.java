package DesignPatterns.creational.abstract_factory;

public class WebFactory implements UiFactory {
    @Override
    public Button createButton() {
        return new DesignPatterns.creational.abstract_factory.web.WebButton();
    }

    @Override
    public Notification createNotification() {
        return new DesignPatterns.creational.abstract_factory.web.WebNotification();
    }
    
}
