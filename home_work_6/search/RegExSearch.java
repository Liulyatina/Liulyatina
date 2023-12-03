package home_work_6.search;

import home_work_6.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        if (word.isEmpty()) {
            return 0;
        }
        // Используем символьные классы Unicode для поддержки русских букв
        Pattern pattern = Pattern.compile("\\b" + word + "\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        long count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}


