package home_work_5.person.Name;

import java.util.Random;

public class RandomName {
    private static final String[] NAMES = {"Roman", "Ilya", "Serghei", "Artur", "Tatiana", "Angelica"};

    public static String randomName() {
                int index = new Random().nextInt(NAMES.length);
                return NAMES[index].toString();
    }
}
