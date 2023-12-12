package test.home_work_6_test;

import home_work_6.ISearchEngine;
import home_work_6.search.RegExSearch;
import home_work_6.search.SearchEngineCaseInsensitive;
import home_work_6.searchApp.MultiThreadSearchApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MultiThreadSearchAppTest {

    private static final String TEST_DIRECTORY_PATH = "src/test/resources/TestBooks";
    private static final String RESULT_FILE_PATH = "result.txt";

    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        // Подменяем System.in для ввода пользовательских данных
        String input = "Мы\nexit\n";
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
    void processFiles_withValidInput_updatesResultMap() throws InterruptedException, ExecutionException {
        // Given
        List<File> textFiles = MultiThreadSearchApp.getTextFiles(TEST_DIRECTORY_PATH);
        Map<String, Integer> resultMap = new ConcurrentHashMap<>();
        ISearchEngine SearchEngineCaseInsensitive = new SearchEngineCaseInsensitive(new RegExSearch());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // When
        List<Future<Void>> futures = MultiThreadSearchApp.processFiles(textFiles, resultMap, SearchEngineCaseInsensitive, "Мы", executorService);

        // Подождем завершения выполнения всех задач
        for (Future<Void> future : futures) {
            future.get();
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Печатаем результаты
        System.out.flush();

        // Then
        assertFalse(resultMap.isEmpty());
        assertEquals(2, resultMap.size());
        assertEquals(2, resultMap.get("testFile1.txt - Мы"));
        assertEquals(1, resultMap.get("testFile2.txt - Мы"));
    }

    private void createTestFiles() {
        try {
            // Создаем тестовые файлы в директории TEST_DIRECTORY_PATH
            File testFile1 = new File(TEST_DIRECTORY_PATH, "testFile1.txt");
            File testFile2 = new File(TEST_DIRECTORY_PATH, "testFile2.txt");
            FileWriter fileWriter1 = new FileWriter(testFile1);
            FileWriter fileWriter2 = new FileWriter(testFile2);
            fileWriter1.write("Мы мыли машину. мы учились программировать ");
            fileWriter2.write("Мыши мыли машину. Мы учились программировать ");
            fileWriter1.close();
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
