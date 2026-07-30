package DesignPatterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        WiredEarphones wiredEarphones = new WiredEarphones();
        AudioAccessory adapter = new TypeCPortAdapter(wiredEarphones);
        ModernPhone modernPhone = new ModernPhone(adapter);

        modernPhone.useAccessory();
    }
}
