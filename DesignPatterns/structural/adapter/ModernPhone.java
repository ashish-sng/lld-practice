package DesignPatterns.structural.adapter;

public class ModernPhone {
    private final AudioAccessory audioAccessory;

    public ModernPhone(AudioAccessory audioAccessory) {
        this.audioAccessory = audioAccessory;
    }

    public void useAccessory() {
        audioAccessory.connect();
    }
}
