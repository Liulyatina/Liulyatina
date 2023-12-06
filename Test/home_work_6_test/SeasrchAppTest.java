package Test.home_work_6_test;

import home_work_6.ISearchEngine;
import home_work_6.search.RegExSearch;
import home_work_6.search.SearchEnginePunctuationNormalizer;
import home_work_6.searchApp.SearchApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchAppTest {

    private static final String TEST_DIRECTORY_PATH = "src/test/resources/TestBooks";
    private static final String RESULT_FILE_PATH = "result.txt";

    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        // Подменяем System.in для ввода пользовательских данных
        String input = "Мы\nмыли\nexit\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Создаем тестовую директорию
        new File(TEST_DIRECTORY_PATH).mkdirs();
        // Создаем тестовые файлы в тестовой директории
        createTestFiles();
    }

    @AfterEach
    void tearDown() throws IOException {
        // Восстанавливаем System.in
        System.setIn(System.in);

        // Удаляем тестовые файлы и файл результатов после каждого теста
        Files.walk(Path.of(TEST_DIRECTORY_PATH))
                .sorted((p1, p2) -> -p1.compareTo(p2)) // Используем сортировку в обратном порядке
                .map(Path::toFile)
                .forEach(File::delete);
        new File(RESULT_FILE_PATH).delete();
    }

    @Test
    void processFile_withValidInput_updatesResultMap() {
        // Given
        List<File> textFiles = SearchApp.getTextFiles(TEST_DIRECTORY_PATH);
        Map<String, Integer> resultMap = new HashMap<>();
        ISearchEngine punctuationNormalize = new SearchEnginePunctuationNormalizer(new RegExSearch());

        // When
        SearchApp.processFile(textFiles, resultMap, punctuationNormalize, "1", new Scanner(System.in));

        // Then
        assertFalse(resultMap.isEmpty());
        assertTrue(resultMap.containsKey("testFile1.txt - мыли"));

    }

    private void createTestFiles() {
        try {
            // Создаем тестовые файлы в директории TEST_DIRECTORY_PATH
            File testFile1 = new File(TEST_DIRECTORY_PATH, "testFile1.txt");
            FileWriter fileWriter1 = new FileWriter(testFile1);
            fileWriter1.write("Мы мыли машину. Мы учились программировать ");
            fileWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
