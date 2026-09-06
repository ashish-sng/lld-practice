package DesignPatterns.creational.abstract_factory.mobile;
import DesignPatterns.creational.abstract_factory.Button;

public class MobileButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mobile Button");
    }
}
