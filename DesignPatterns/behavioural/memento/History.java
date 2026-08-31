package DesignPatterns.behavioural.memento;

import java.util.*;

public class History {
    private final Stack<EditorState> history = new Stack<>();

    public void saveState(EditorState state) {
        history.push(state);
    }

    public EditorState undo() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }
}
