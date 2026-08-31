# Memento Pattern: Text Editor Undo/Redo Engine

The **Memento Pattern** is a behavioral design pattern that allows you to capture and restore an object's internal state (**Undo / Redo** mechanism) without exposing its implementation details or violating encapsulation.

---

## 🎯 The Real-World Industry Problem

Think of a text editor like **VS Code**, **Notepad**, or **Google Docs**:

- As you type text, change font sizes, or move cursors, the editor's state changes.
- When you press `Ctrl+Z` (Undo), the editor should instantly revert to its previous state.
- When you press `Ctrl+Y` (Redo), it reapplies the undone state.

### ❌ Without Memento
If the `History` class directly reaches into `TextEditor` to save and modify internal fields (`content`, `cursorPosition`), it violates **Encapsulation**. If `TextEditor` adds new state fields in the future, the `History` class breaks!

---

## 💡 The 3 Core Roles in Memento

```
┌─────────────────────────┐           ┌─────────────────────────┐
│        Caretaker        │           │       Originator        │
│        (History)        │           │      (TextEditor)       │
│                         │           │                         │
│  - Stack<EditorState>   │           │  - content              │
│    undoHistory          │           │  - cursorPosition       │
└────────────┬────────────┘           └────────────┬────────────┘
             │                                     │
             │ stores snapshots                    │ creates & restores
             ▼                                     ▼
┌───────────────────────────────────────────────────────────────┐
│                          EditorState                          │
│                           (Memento)                           │
│  - Immutable snapshot of content & cursorPosition            │
└───────────────────────────────────────────────────────────────┘
```

1. **Originator (`TextEditor`)**:
   - The object whose state needs saving/restoration.
   - Methods: `EditorState save()` and `void restore(EditorState memento)`.

2. **Memento (`EditorState`)**:
   - Immutable snapshot holding `content` and `cursorPosition` at a single point in time.

3. **Caretaker (`History`)**:
   - Maintains the history stack (`Stack<EditorState>`).
   - Pushes new snapshots on edit, and pops them when `undo()` is requested.

---

## 🛠️ Step-by-Step Guided Implementation

### 1. Create the Memento (`EditorState.java`)
- Holds `private final String content;` and `private final int cursorPosition;`.
- Immutable: values are set once via constructor, only getters exist.

### 2. Create the Originator (`TextEditor.java`)
- Holds `content` and `cursorPosition`.
- `public EditorState save()` $\rightarrow$ returns `new EditorState(content, cursorPosition)`.
- `public void restore(EditorState state)` $\rightarrow$ updates `this.content` and `this.cursorPosition` from `state`.

### 3. Create the Caretaker (`History.java`)
- Holds `private final Stack<EditorState> undoStack = new Stack<>();`.
- `public void push(EditorState state)` $\rightarrow$ saves a snapshot.
- `public EditorState pop()` $\rightarrow$ pops and returns the previous snapshot.

### 4. Test in `Main.java`
- Type text $\rightarrow$ save snapshot $\rightarrow$ make changes $\rightarrow$ perform `undo()` $\rightarrow$ verify previous state is restored!
