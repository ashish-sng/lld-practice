package DesignPatterns.structural.proxy;

public class DocumentProxy implements Document {
    @Override
    public void view(String userRole) {
        if ("admin".equals(userRole)) {
            RealDocument realDocument = new RealDocument();
            realDocument.view(userRole);
        } else {
            System.out.println("Access denied. Only admin can view the document.");
        }
    }
}
