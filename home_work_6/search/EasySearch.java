package home_work_6.search;

import home_work_6.ISearchEngine;

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        String[] words = text.split("\\s+");
        long count = 0;

        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }

        return count;
    }
}

