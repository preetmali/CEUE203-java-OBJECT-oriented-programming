import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) {
        Path folder = Paths.get("logs");

        try {
            Files.createDirectories(folder);

            Files.write(folder.resolve("log1.txt"), List.of(
                    "Application started",
                    "ERROR: Database connection failed",
                    "User logged in"));

            Files.write(folder.resolve("log2.txt"), List.of(
                    "Server started",
                    "ERROR: File not found",
                    "Application closed"));

            Files.write(folder.resolve("log3.txt"), List.of(
                    "User registered",
                    "Data saved successfully",
                    "ERROR: Invalid input"));

            int totalLines = 0;
            int errorLines = 0;

            try (DirectoryStream<Path> files = Files.newDirectoryStream(folder, "*.txt")) {

                for (Path file : files) {
                    System.out.println("\nFile: " + file.getFileName());

                    BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

                    System.out.println("Size: " + attr.size() + " bytes");

                    try (var reader = Files.newBufferedReader(file)) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                            totalLines++;

                            if (line.contains("ERROR")) {
                                errorLines++;
                                System.out.println("Found: " + line);
                            }
                        }
                    }
                }
            }

            System.out.println("\nTotal Lines: " + totalLines);
            System.out.println("ERROR Lines: " + errorLines);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("25ce057");
    }
}
