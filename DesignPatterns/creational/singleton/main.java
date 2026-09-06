package DesignPatterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();

        logger1.log("Hello");
        logger2.log("World");

        System.out.println(logger1 == logger2);
    }
}
