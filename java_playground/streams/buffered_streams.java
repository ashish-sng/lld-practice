package java_playground.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class buffered_streams {
    public static void main(String[] args) {
        String sourceFile = "java_playground/streams/input.txt";
        String targetFile = "java_playground/streams/output.txt";

        // try-with-resources closes both reader and writer automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            // readLine() returns null when the end of the file is reached
            while ((line = reader.readLine()) != null) {
                // Example processing: write only non-empty lines in uppercase
                if (!line.isBlank()) {
                    writer.write(line);
                    writer.newLine(); // Writes OS-independent newline (\n or \r\n)
                }
            }
            System.out.println("File processed successfully.");

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}
