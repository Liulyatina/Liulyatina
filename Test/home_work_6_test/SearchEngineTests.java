package Test.home_work_6_test;

import home_work_6.ISearchEngine;
import home_work_6.search.EasySearch;
import home_work_6.search.RegExSearch;
import home_work_6.search.SearchEngineCaseNormalizer;
import home_work_6.search.SearchEnginePunctuationNormalizer;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchEngineTests {

    @Test
    void easySearchTest() {
        ISearchEngine searchEngine = new EasySearch();
        assertEquals(1, searchEngine.search("мама мыла раму", "мыла"));
        assertEquals(2, searchEngine.search("мыла мыла- мыла мыла-мыла мыла_мыла", "мыла"));
        assertEquals(1, searchEngine.search("мыла мыла- мыла мыла-мыла мыла_мыла", "мыла-мыла"));
        assertEquals(0, searchEngine.search("мама мыла раму", "Мыла"));
        assertEquals(1, searchEngine.search("мама мыла, мыла раму", "мыла"));
        assertEquals(0, searchEngine.search("мама мыла раму", "мылаа"));
        assertEquals(0, searchEngine.search("мама мыла раму", "мылa")); //а латинская
        assertEquals(0, searchEngine.search("мама мыла раму", ""));
        assertEquals(0, searchEngine.search("мама мыла раму", "\\."));
        assertEquals(0, searchEngine.search("мама мыла мыла мыла раму", "мыл"));
        assertEquals(0, searchEngine.search("Мама мыла раму", "папа"));
    }

    @Test
    void regExSearchTest() {
        ISearchEngine searchEngine = new RegExSearch();
        assertEquals(1, searchEngine.search("мама мыла раму", "мыла"));
        assertEquals(0, searchEngine.search("мама мыла раму", "Мыла"));
        assertEquals(6, searchEngine.search("мама мыла, мыла-мыла-мыла-мыла мыла раму", "мыла"));
        assertEquals(0, searchEngine.search("мама мыла раму", "мылаа"));
        assertEquals(0, searchEngine.search("мама мыла раму", "мылa")); //а латинская
        assertEquals(0, searchEngine.search("мама мыла раму", ""));
        assertEquals(0, searchEngine.search("мама мыла раму", "\\."));
        assertEquals(0, searchEngine.search("мама мыла мыла мыла раму", "мыл"));
        assertEquals(0, searchEngine.search("Мама мыла раму", "папа"));
    }

    @Test
    void punctuationNormalizerTest() {
        ISearchEngine searchEngine = new SearchEnginePunctuationNormalizer(new EasySearch());
        assertEquals(1, searchEngine.search("Мама, мыла. раму!", "мыла"));
        assertEquals(2, searchEngine.search("Мама, мыла/ мыла раму!", "мыла"));
        assertEquals(0, searchEngine.search("Мама, мыла$ раму!", "Мыла"));
        assertEquals(0, searchEngine.search("Мама, мыла... раму!", "мы"));
        assertEquals(0, searchEngine.search("Мама, мыла... раму!", "мыла..."));
        assertEquals(0, searchEngine.search("Мама, мыла... раму!", "\\."));
        assertEquals(0, searchEngine.search("Мама мыла раму", "папа"));
    }

    @Test
    void searchEngineCaseNormalizerTest() {
        ISearchEngine searchEngine = new SearchEngineCaseNormalizer(new EasySearch(), Locale.getDefault());

        assertEquals(1, searchEngine.search("Мама мЫла раму", "МЫЛА"));
        assertEquals(2, searchEngine.search("Мама мыла Мыла раму", "МЫла"));
        assertEquals(0, searchEngine.search("Мама мыла Мыла раму", "МЫ"));
        assertEquals(0, searchEngine.search("Мама мыла Мыла раму", "МЫлa")); // a латинское
        assertEquals(0, searchEngine.search("Мама мыла раму", "ПАПА"));
        //assertEquals(3, searchEngine.search("бабушка бабушке бабушку", "БаБуШкА"));
    }

    @Test
    void caseAndPunctuationNormalizerTest() {
        ISearchEngine searchEngine = new SearchEngineCaseNormalizer(new RegExSearch(), Locale.getDefault());
        assertEquals(1, searchEngine.search("Мама мЫла раму", "МЫЛА"));
        assertEquals(2, searchEngine.search("Мама мыла Мыла раму", "МЫла"));
        assertEquals(0, searchEngine.search("Мама мыла Мыла раму", "МЫ"));
        assertEquals(0, searchEngine.search("Мама мыла Мыла раму", "МЫлa")); // a латинское
        assertEquals(0, searchEngine.search("Мама мыла раму", "ПАПА"));
    }

    @Test
    void caseAndPunctuationNormalizerRegExTest() {
        ISearchEngine searchEngine = new SearchEnginePunctuationNormalizer(new RegExSearch());
        assertEquals(1, searchEngine.search("Мама, мыла. раму!", "мыла"));
        assertEquals(2, searchEngine.search("Мама, мыла/ мыла раму!", "мыла"));
        assertEquals(0, searchEngine.search("Мама, мыла$ раму!", "Мыла"));
        assertEquals(0, searchEngine.search("Мама, мыла... раму!", "мы"));
        assertEquals(0, searchEngine.search("Мама, мыла... раму!", "мыла..."));
        assertEquals(0, searchEngine.search("Мама, мыла... раму!", "\\."));
        assertEquals(0, searchEngine.search("Мама мыла раму", "папа"));
    }
    @Test
    void testSearchWithNoMatchesRegExSearch() {
        ISearchEngine searchEngine = new RegExSearch();
        assertEquals(0, searchEngine.search("Hello, World!", "Java"));
        assertEquals(0, searchEngine.search("12345", "567"));
    }
    @Test
    void testSearchWithNoMatchesEasySearch() {
        ISearchEngine searchEngine = new EasySearch();
        assertEquals(0, searchEngine.search("Hello, World!", "Java"));
        assertEquals(0, searchEngine.search("12345", "567"));
    }
}
