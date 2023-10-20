import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scores {
    private final Path FILE = Paths.get("rating.txt");

    private Map<String, Integer> scores = new HashMap<>();

    Scores() {
        readFile();
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    private void readFile() {
        try {
            if (!Files.exists(FILE)) {
                Files.createFile(FILE);
            }

            List<String> lines = Files.readAllLines(FILE);
            for (String line : lines) {
                String[] parts = line.split(" ");
                scores.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void updateFile() {
        try {
            List<String> lines = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                lines.add(entry.getKey() + " " + entry.getValue());
            }
            Files.write(FILE, lines);
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}
