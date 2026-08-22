package DesignPatterns.structural.composite;

import java.util.*;

public class DirectoryItem implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public DirectoryItem(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public void remove(FileSystemItem item) {
        children.remove(item);
    }

    @Override
    public long getSize() {
        long totalSize = 0;

        for (FileSystemItem child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String indent) {
        System.out.println(
                indent + "📁 " + name);

        for (FileSystemItem child : children) {
            child.print(indent + "  ");
        }
    }


}
