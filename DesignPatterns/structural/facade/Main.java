package DesignPatterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        MorningRoutineFacade morningRoutineFacade = new MorningRoutineFacade();
        morningRoutineFacade.getReadyForOffice();
    }
}
