
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FolderReport {
    public static void main(String[] args) {
        Path root = Paths.get("lab-NN");
        Path report = Paths.get("report.txt");

        List<String> details = new ArrayList<>();

        details.add("FOLDER TREE REPORT");
        details.add("==================");

        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
                Files.writeString(root.resolve("sample.txt"),
                        "This is a sample file.");
            }

            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(
                        Path file, BasicFileAttributes attrs) {

                    String name = file.getFileName().toString();
                    long size = attrs.size();
                    String modified = attrs.lastModifiedTime().toString();

                    details.add(
                            "Name: " + name
                                    + " | Size: " + size + " bytes"
                                    + " | Modified: " + modified);

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(
                        Path file, IOException exc) {

                    details.add("Cannot access: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });

            Files.write(report, details);

            System.out.println("Report generated successfully!");
            System.out.println("Report file: " + report.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("25ce057");
    }
}
