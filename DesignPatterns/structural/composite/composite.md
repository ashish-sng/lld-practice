# Composite Pattern: Industry-Level File System Engine

The **Composite Pattern** allows you to compose objects into tree structures to represent part-whole hierarchies. It lets client code treat individual leaf objects (`File`) and compositions of objects (`Directory`) uniformly.

---

## 🎯 The Real-World Industry Problem

Consider a Unix/Cloud File System (like Linux VFS, AWS S3, or Google Drive):
- A **File** has a name and a specific size in bytes.
- A **Directory** has a name and contains a list of items. Those items can be **Files** OR **sub-Directories**!

When you query the size of a folder (e.g. `du -sh` or Right Click $\rightarrow$ Properties), or print a directory tree (`tree`), the system recursively calculates the total size and prints the nested structure.

---

## ❌ Without the Composite Pattern

Without Composite, your client code has to constantly check types:
```java
if (item instanceof Directory) {
    // Loop through sub-items, check if sub-item is directory or file...
} else if (item instanceof File) {
    // Return file size...
}
```
This leads to messy nested `if-else` loops, type checking (`instanceof`), and code that breaks whenever new file system types are added.

---

## ✅ With the Composite Pattern

Both `FileItem` (Leaf) and `DirectoryItem` (Composite) implement a single interface: `FileSystemItem`.

```
                    ┌─────────────────┐
                    │ FileSystemItem  │ (Interface)
                    │  - getName()    │
                    │  - getSize()    │
                    │  - print(...)   │
                    └────────┬────────┘
                             │
            ┌────────────────┴────────────────┐
            ▼                                 ▼
   ┌────────────────┐                ┌────────────────┐
   │    FileItem    │                │ DirectoryItem  │
   │    (Leaf)      │                │  (Composite)   │
   └────────────────┘                └────────┬───────┘
                                              │
                                              │ holds List of
                                              └────────► [ FileSystemItem ]
```

The client calls `.getSize()` or `.print("")` on the root `FileSystemItem`, and polymorphism + recursion handle the entire tree seamlessly!

---

## 🛠️ Step-by-Step Practice Guide

### 1. Component Interface
Create `FileSystemItem.java`:
- `String getName()`
- `long getSize()`
- `void print(String indent)`

### 2. Leaf Object
Create `FileItem.java`:
- Implements `FileSystemItem`.
- Stores `name` and `sizeInBytes`.
- `getSize()` returns `sizeInBytes`.
- `print(indent)` prints `indent + "📄 " + name + " (" + sizeInBytes + " bytes)"`.

### 3. Composite Object
Create `DirectoryItem.java`:
- Implements `FileSystemItem`.
- Stores `name` and `List<FileSystemItem> children = new ArrayList<>()`.
- Methods: `add(FileSystemItem item)`, `remove(FileSystemItem item)`.
- `getSize()`: Loops through `children`, sums `child.getSize()`, and returns total bytes recursively!
- `print(indent)`: Prints `indent + "📁 " + name`, then loops through `children` calling `child.print(indent + "  ")`.

### 4. Client Execution
Use `DirectoryItem` and `FileItem` in `Main.java` to build a complex directory tree and calculate total storage usage.

