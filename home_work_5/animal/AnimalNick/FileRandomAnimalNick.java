package home_work_5.animal.AnimalNick;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class FileRandomAnimalNick {
    public static final String FILE_NICK = "Task_Nick.txt";
    public static String generateRandomFileNick() throws IOException {
        List<String> names = Files.readAllLines(Paths.get(FILE_NICK));
        int index = new Random().nextInt(names.size());
        return names.get(index);
    }
}
