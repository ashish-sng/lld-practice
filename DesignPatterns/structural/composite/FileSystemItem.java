package DesignPatterns.structural.composite;

public interface FileSystemItem {
    String getName();

    long getSize(); // size in bytes

    void print(String indent); // Pretty print directory tree
}
