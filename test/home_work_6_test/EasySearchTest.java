package test.home_work_6_test;

import home_work_6.ISearchEngine;
import home_work_6.search.EasySearch;
import home_work_6.search.RegExSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EasySearchTest {

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("Мы мыли мылом машину", "мыли"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search2(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("привет,какдела!", "привет"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search3(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("привет;какдела!", "привет"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search4(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("-привет ;какдела!", "привет"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search5(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("как дела!.Что делаешь?", "дела"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search6(ISearchEngine se) {
        Assertions.assertEquals(0, se.search("привет-привет", "привет"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search7(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("привет-привет", "привет-привет"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search8(ISearchEngine se) {
        Assertions.assertEquals(0, se.search("привет--привет", "привет"));
    }

    @ParameterizedTest
    @MethodSource("searchEngineProvider")
    public void search9(ISearchEngine se) {
        Assertions.assertEquals(1, se.search("Мы учили программирование, мы молодцы", "мы"));
    }

    public static Stream<ISearchEngine> searchEngineProvider() {
        return Stream.of(
                new EasySearch(),
                new RegExSearch()
        );
    }
}