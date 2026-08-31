# Memento is a behavioral design pattern that allows capturing and restoring an object's internal state without exposing its implementation details.

Memento pattern works like a snapshot or checkpoint mechanism. It allows an application to save the state of an object so that it can be restored later (for Undo/Redo operations) without breaking encapsulation or exposing private fields to external classes.

# Memento Pattern in This Example

This example uses the Memento pattern for a practical text editor use case:

- an application allows users to type text into a `TextEditor`
- as edits happen, the editor's internal state (`content`, `cursorPosition`) changes
- the application wants to provide an `Undo` feature to revert back to previous states

Our text editor code performs actions like:

```java
TextEditor txt = new TextEditor();
History history = new History();

txt.write("Ashish");
history.saveState(txt.save()); // Save snapshot of "Ashish"

txt.write(" Singh"); // Content becomes "Ashish Singh"
```

And when the user requests an Undo:

```java
txt.restore(history.undo()); // Content reverts to "Ashish"
```

The Memento pattern separates state capture from state storage cleanly.

## Classes and their roles

- `EditorState`
  - This is the Memento.
  - It is an immutable snapshot of the editor's internal state at a specific point in time.
  - It holds:
    - `content`
    - `cursorPosition`

- `TextEditor`
  - This is the Originator.
  - It holds the active state being modified.
  - It creates mementos via `save()`.
  - It restores its state from mementos via `restore(EditorState)`.

- `History`
  - This is the Caretaker.
  - It manages the history stack of saved mementos (`Stack<EditorState>`).
  - It pushes new mementos via `saveState()`.
  - It pops past mementos via `undo()`.
  - It does NOT inspect or modify the contents inside the mementos.

- `Main`
  - This is the client code demonstrating writing text, taking snapshots, and reverting state using `undo()`.

## How it works

In `Main`, we create the originator and caretaker objects:

```java
TextEditor txt = new TextEditor();
History history = new History();
```

Then we perform an edit and save a snapshot BEFORE making further edits:

```java
txt.write("Ashish");
history.saveState(txt.save());
```

Then we write additional text:

```java
txt.write(" Singh");
txt.print(); // Prints: Content: Ashish Singh (12)
```

Then we trigger an Undo:

```java
txt.restore(history.undo());
txt.print(); // Reverts to: Content: Ashish (6)
```

## Flow of control

When this sequence runs:

1. `txt.write("Ashish")` updates `TextEditor` state to `content="Ashish"`, `cursorPosition=6`.
2. `txt.save()` creates a new `EditorState("Ashish", 6)`.
3. `history.saveState(...)` pushes this memento onto `History`'s stack.
4. `txt.write(" Singh")` updates `TextEditor` state to `content="Ashish Singh"`, `cursorPosition=12`.
5. `history.undo()` pops `EditorState("Ashish", 6)` off the stack.
6. `txt.restore(...)` overwrites current state with values from the popped memento.

So the editor returns to its exact state before the second edit.

## Why this is useful

Without Memento:

- `History` or `Main` would need direct access to `TextEditor`'s private fields (`content`, `cursorPosition`).
- External code would be responsible for copying and managing internal fields, violating **Encapsulation**.
- Adding new internal state fields (e.g. `selectionStart`, `fontName`) would break external history code across the application.

With Memento:

- `TextEditor` alone decides how to capture and restore its internal state.
- `History` only holds opaque memento objects without needing to know their internal structure.
- Encapsulation remains intact, and adding new state fields requires changes ONLY inside `TextEditor` and `EditorState`.

## Why this example feels practical

This is a very real software engineering scenario.

In actual production systems, state snapshotting and undo mechanisms are used in:

- Text editors and IDEs (VS Code, IntelliJ, Notepad)
- Graphic design & CAD tools (Photoshop, Figma, Canvas elements)
- Database transactions (Savepoints and Rollbacks)
- Game engines (State checkpoints and Quick-Saves)
- Multi-step wizard forms (Navigating back to previous steps without data loss)

## Interview Notes

- Definition:
  - Memento captures and externalizes an object's internal state so that the object can be restored to this state later without violating encapsulation.

- Intent:
  - Use it when you need to implement Undo/Redo or checkpoint/rollback mechanisms while preserving object encapsulation.

- Real-world signal:
  - Your application needs to revert an object back to a previous state, but you don't want external classes accessing its private variables.

- In this example:
  - `TextEditor` is the Originator
  - `EditorState` is the Memento
  - `History` is the Caretaker

- Main benefit:
  - Preserves encapsulation boundaries while enabling state restoration.

- Common interview line:
  - "Memento is a snapshot mechanism for Undo/Redo that protects encapsulation."

- Difference from Command Pattern:
  - Command encapsulates an action and implements undo by executing inverse operations (e.g. `add` $\rightarrow$ `subtract`).
  - Memento saves the exact state snapshot at a point in time without tracking operational logic.

- Difference from State Pattern:
  - State pattern changes an object's behavior depending on its current state.
  - Memento pattern captures and restores state snapshots over time.

- When to use:
  - Undo / Redo features in editors
  - Transaction rollback or savepoint features
  - Checkpoint systems in game engines or workflow pipelines

- One strong design takeaway:
  - The Originator creates and consumes Mementos; the Caretaker stores Mementos without inspecting or altering them.
