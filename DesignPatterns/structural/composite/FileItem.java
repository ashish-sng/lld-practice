package DesignPatterns.structural.composite;

public class FileItem implements FileSystemItem {
    private final String name;
    private final long sizeInBytes;

    public FileItem(String name, long sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public long getSize() {
        return sizeInBytes;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📄 " + name + " (" + sizeInBytes + " bytes)");
    }
}
