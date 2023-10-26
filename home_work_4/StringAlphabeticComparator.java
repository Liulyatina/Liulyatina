package home_work_4;

import java.util.Comparator;

public class StringAlphabeticComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // Сравниваем строки в алфавитном порядке
        return s1.compareTo(s2);
    }
}

