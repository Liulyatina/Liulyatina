package home_work_6.search;

import home_work_6.ISearchEngine;
 public class SearchEngineCaseInsensitive implements ISearchEngine {
        private final ISearchEngine searchEngine;

        public SearchEngineCaseInsensitive(ISearchEngine searchEngine) {
            this.searchEngine = searchEngine;
        }

        @Override
        public long search(String text, String word) {
            text = text.toLowerCase();
            word = word.toLowerCase();
            return searchEngine.search(text, word);
        }
}
