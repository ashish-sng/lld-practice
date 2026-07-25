package DesignPatterns.behavioural.observer;

public class Main {
    public static void main(String[] args) {
        LaundryMachine laundryMachine = new LaundryMachine("Laundry Machine 2");

        Observer aarav = new Roommate("Aarav");
        Observer meera = new Roommate("Meera");
        Observer kabir = new Roommate("Kabir");

        laundryMachine.addObserver(aarav);
        laundryMachine.addObserver(meera);
        laundryMachine.addObserver(kabir);

        laundryMachine.setStatus("Wash cycle started");
        laundryMachine.setStatus("10 minutes left");

        laundryMachine.removeObserver(kabir);
        laundryMachine.setStatus("Cycle complete, please collect your clothes");
    }
}
