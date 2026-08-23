package DesignPatterns.structural.proxy;

public class RealDocument implements Document {
    @Override
    public void view(String userRole) {
        System.out.println("Viewing document as " + userRole);
    }
}
