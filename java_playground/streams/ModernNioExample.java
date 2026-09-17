package java_playground.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class ModernNioExample {
    public static void main(String[] args) {
        Path path = Path.of("java_playground/streams/server.log");

        try {
            // 1. Write or Append text directly
            Files.writeString(path, "INFO: System started\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(path, "ERROR: Connection timeout\n", StandardOpenOption.APPEND);

            // 2. Read entire file into a String (best for small/medium config files)
            String content = Files.readString(path);
            System.out.println("--- Full Content ---");
            System.out.println(content);

            // 3. Read lines as a List
            List<String> allLines = Files.readAllLines(path);
            System.out.println("Line count: " + allLines.size());

            // 4. Stream large files line-by-line (Memory safe: does not load file into RAM)
            System.out.println("--- Filtered Errors ---");
            try (Stream<String> lines = Files.lines(path)) {
                lines.filter(l -> l.startsWith("ERROR"))
                     .forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println("NIO Error: " + e.getMessage());
        }
    }
}