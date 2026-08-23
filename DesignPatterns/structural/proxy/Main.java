package DesignPatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Document documentProxy = new DocumentProxy();

        // Admin user can view the document
        System.out.println("Admin trying to view the document:");
        documentProxy.view("admin");

        // Non-admin user cannot view the document
        System.out.println("\nUser trying to view the document:");
        documentProxy.view("user");
    }
}
