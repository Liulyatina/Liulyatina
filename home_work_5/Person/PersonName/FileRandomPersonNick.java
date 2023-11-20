package home_work_5.Person.PersonName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class FileRandomPersonNick {
    public static final String FILE_PERSON_NICK = "Task_PersonNick.txt";
    public static String generateRandomFilePersonNick() throws IOException {
        List<String> names = Files.readAllLines(Paths.get(FILE_PERSON_NICK));
        int index = new Random().nextInt(names.size());
        return names.get(index);
    }
}
