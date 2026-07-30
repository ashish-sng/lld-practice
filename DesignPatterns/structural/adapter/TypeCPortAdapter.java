package DesignPatterns.structural.adapter;

public class TypeCPortAdapter implements AudioAccessory {
    private final WiredEarphones wiredEarphones;

    public TypeCPortAdapter(WiredEarphones wiredEarphones) {
        this.wiredEarphones = wiredEarphones;
    }

    @Override
    public void connect() {
        System.out.println("Adapter converts USB-C port for legacy audio accessory");
        wiredEarphones.connectTo3Point5MmJack();
    }
}
