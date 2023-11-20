package home_work_5.Person.PersonName;

import java.util.Random;

public class RandomPersonNick {
    private static final String[] PERSON_NICKS = {"Liulyatina", "Simple", "Sweet", "Cj", "Killer", "Po"};

    public static String randomPersonNick() {
                int index = new Random().nextInt(PERSON_NICKS.length);
                return PERSON_NICKS[index].toString();
    }
}
