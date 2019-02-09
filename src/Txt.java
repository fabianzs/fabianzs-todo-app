import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface Txt {
    static List<String> readFile() {
        Path filePath = Paths.get("C:/Users/Zsófi/greenfox/fabianzs-todo-app/src/tasks.txt");
        List<String> allLines = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(filePath)) {
                allLines.add(line);
            }
        } catch (IOException ex) {
            System.out.println("The file does not exist.");
        }
        return allLines;
    }

    static void writeFile(List<String> linesToWrite) {
        Path filePath = Paths.get("C:/Users/Zsófi/greenfox/fabianzs-todo-app/src/tasks.txt");
        try {
            Files.write(filePath, linesToWrite);
        } catch (IOException ex) {
            System.out.println("The file does not exist.");
        }
    }
}
