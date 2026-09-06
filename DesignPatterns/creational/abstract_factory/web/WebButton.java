package DesignPatterns.creational.abstract_factory.web;
import DesignPatterns.creational.abstract_factory.Button;

public class WebButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Web Button");
    }
}
