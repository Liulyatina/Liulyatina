package home_work_6.search;

import home_work_6.ISearchEngine;

public class SearchEnginePunctuationNormalizer implements ISearchEngine {
    private final ISearchEngine searchEngine;

    public SearchEnginePunctuationNormalizer(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
        String normalizedText = text.replaceAll("[^\\p{L}\\s]", "");

        return searchEngine.search(normalizedText, word);
    }
}
