package home_work_6;

import home_work_6.search.EasySearch;
import home_work_6.search.SearchEngineCaseInsensitive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        ISearchEngine easySearch = new EasySearch();
        ISearchEngine searchEngineCaseInsensitive = new SearchEngineCaseInsensitive(new EasySearch());
        try (BufferedReader reader = new BufferedReader(new FileReader("Война_и_мир_книга.txt"))) {
            StringBuilder fullText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fullText.append(line).append("\n");
            }
            printSearchResults("EasySearch", easySearch, fullText.toString());
            printSearchResults("SearchEngineCaseInsensitive", searchEngineCaseInsensitive, fullText.toString());

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void printSearchResults(String engineName, ISearchEngine searchEngine, String text) {
        System.out.println("Results for " + engineName + ":");
        System.out.println("Война: " + searchEngine.search(text, "война"));
        System.out.println("И: " + searchEngine.search(text, "и"));
        System.out.println("Мир: " + searchEngine.search(text, "мир"));
        System.out.println();
    }
}

