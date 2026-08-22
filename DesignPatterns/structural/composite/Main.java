package DesignPatterns.structural.composite;

public class Main {
    public static void main(String[] args) {
        //Create individual leaf files
        FileSystemItem file1 = new FileItem("resume.pdf", 1200);
        FileSystemItem file2 = new FileItem("photo.png", 1300);

        // Create a sub-directory and add files into it
        DirectoryItem projectsDir = new DirectoryItem("projects");
        projectsDir.add(new FileItem("App.java", 2400));
        projectsDir.add(new FileItem("index.html", 2800));

        // Create the root directory
        DirectoryItem rootDir = new DirectoryItem("root");
        rootDir.add(file1);
        rootDir.add(file2);
        rootDir.add(projectsDir);

        System.out.println("=== FILE SYSTEM TREE ===");
        rootDir.print("");
        System.out.println("\n=== CALCULATED STORAGE USAGE ===");
        System.out.println("Total Root Folder Size    : " + rootDir.getSize() + " bytes");
        System.out.println("Projects Sub-Folder Size  : " + projectsDir.getSize() + " bytes");
        System.out.println("Single File ('resume.pdf'): " + file1.getSize() + " bytes");
        
    }
}

