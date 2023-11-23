package home_work_5.person;

import java.util.Comparator;

public class PersonComparator {
    public static class LengthPasswordComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) { return p1.getPassword().length() - p2.getPassword().length();
        }
    }

    public static class LengthPasswordAndNickComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            int passwordLengthCompare = p1.getPassword().length() - p2.getPassword().length();
            return (passwordLengthCompare != 0) ? passwordLengthCompare : p1.getNick().compareTo(p2.getNick());
        }
    }
}
