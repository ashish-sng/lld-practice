package DesignPatterns.behavioural.memento;

public class TextEditor {
    private String content;
    private int cursorPosition;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
    }

    public void write(String text) {
        content = content + text;
        cursorPosition += text.length();
    }

    public EditorState save() {
        return new EditorState(content, cursorPosition);
    }

    public void restore(EditorState state) {
        this.content = state.getContent();
        this.cursorPosition = state.getCursorPosition();
    }

    public void print() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
    }
}
