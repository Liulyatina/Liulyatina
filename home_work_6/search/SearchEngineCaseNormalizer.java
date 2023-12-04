package home_work_6.search;

import home_work_6.ISearchEngine;

import java.util.Locale;

public class SearchEngineCaseNormalizer implements ISearchEngine {
    private final ISearchEngine searchEngine;
    private final Locale locale;

    public SearchEngineCaseNormalizer(ISearchEngine searchEngine, Locale locale) {
        this.searchEngine = searchEngine;
        this.locale = locale;
    }

    @Override
    public long search(String text, String word) {
        text = text.toLowerCase();
        word = word.toLowerCase();
        return searchEngine.search(text, word);
    }
}
