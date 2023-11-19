package home_work_5.Animal.AnimalNick;

import java.util.Random;

public class RandomAnimalNick {
    private static final String[] NICKS = {"Badi", "Charlie", "Bear", "Shit", "Max", "Doni"};

    public static String randomNick() {
                int index = new Random().nextInt(NICKS.length);
                return NICKS[index].toString();
    }
}
