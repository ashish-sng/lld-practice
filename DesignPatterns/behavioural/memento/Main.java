package DesignPatterns.behavioural.memento;

public class Main {
    public static void main(String[] args) {
        TextEditor txt = new TextEditor();
        History history = new History();

        txt.write("Ashish");
        history.saveState(txt.save());

        txt.write(" Singh");

        txt.print();

        // Undo reverts back to "Hello"
        txt.restore(history.undo());
        System.out.println("\n=== AFTER UNDO ===");
        txt.print();
    }
}
