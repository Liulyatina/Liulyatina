package Test.home_work_6_test;

import home_work_6.ISearchEngine;
import home_work_6.search.RegExSearch;
import home_work_6.search.SearchEnginePunctuationNormalizer;
import home_work_6.searchApp.MultiThreadSearchApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class MultiThreadSearchAppTest {

    private static final String TEST_DIRECTORY_PATH = "src/test/resources/TestBooks";
    private static final String RESULT_FILE_PATH = "result.txt";

    @BeforeEach
    void setUp() {
        // Создаем тестовую директорию
        new File(TEST_DIRECTORY_PATH).mkdirs();
        // Создаем тестовые файлы в тестовой директории
        createTestFiles();
    }

    @AfterEach
    void tearDown() throws IOException {
        // Удаляем тестовые файлы и файл результатов после каждого теста
        Files.walk(Path.of(TEST_DIRECTORY_PATH))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        new File(RESULT_FILE_PATH).delete();
    }

    @Test
    void processFiles_withValidInput_updatesResultMap() {
        // Given
        List<File> textFiles = MultiThreadSearchApp.getTextFiles(TEST_DIRECTORY_PATH);
        Map<String, Integer> resultMap = new ConcurrentHashMap<>();
        ISearchEngine punctuationNormalize = new SearchEnginePunctuationNormalizer(new RegExSearch());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // When
        MultiThreadSearchApp.processFiles(textFiles, resultMap, punctuationNormalize, "word1", executorService);

        // Then
        assertFalse(resultMap.isEmpty());
        assertTrue(resultMap.containsKey("testFile1.txt - word1"));
    }

    @Test
    void writeResultsToFile_withValidResultMap_writesResultsToFile() throws IOException {
        // Given
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("testFile1.txt - word1 - 3", 3);
        resultMap.put("testFile2.txt - word1 - 1", 1);

        // When
        MultiThreadSearchApp.writeResultsToFile(resultMap);

        // Then
        assertTrue(new File(RESULT_FILE_PATH).exists());
        List<String> lines = Files.readAllLines(Path.of(RESULT_FILE_PATH));
        assertEquals(2, lines.size());
        assertTrue(lines.contains("testFile1.txt - word1 - 3"));
        assertTrue(lines.contains("testFile2.txt - word1 - 1"));
    }

    private void createTestFiles() {
        try {
            // Создаем тестовые файлы в директории TEST_DIRECTORY_PATH
            File testFile1 = new File(TEST_DIRECTORY_PATH, "testFile1.txt");
            File testFile2 = new File(TEST_DIRECTORY_PATH, "testFile2.txt");

            FileWriter fileWriter1 = new FileWriter(testFile1);
            FileWriter fileWriter2 = new FileWriter(testFile2);

            fileWriter1.write("This is a test file content with word1 and word2.");
            fileWriter2.write("This is another test file content with word1.");

            fileWriter1.close();
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
