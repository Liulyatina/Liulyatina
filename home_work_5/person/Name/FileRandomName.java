package home_work_5.person.Name;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class FileRandomName {
    public static final String FILE_NAME = "Task_Name.txt";
    public static String generateRandomFileName() throws IOException {
        List<String> names = Files.readAllLines(Paths.get(FILE_NAME));
        int index = new Random().nextInt(names.size());
        return names.get(index);
    }
}
