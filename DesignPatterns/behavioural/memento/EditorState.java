package DesignPatterns.behavioural.memento;

public class EditorState {
    private final String content;
    private final int cursorPosition;

    public EditorState(String content, int cursorPosition) {
        this.content = content;
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}
