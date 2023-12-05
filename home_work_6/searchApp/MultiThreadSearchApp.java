package home_work_6.searchApp;

import home_work_6.ISearchEngine;
import home_work_6.search.EasySearch;
import home_work_6.search.SearchEngineCaseInsensitive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadSearchApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
///Users/romamihalevic/IdeaProjects/Home_work/src/Books
        System.out.println("Введите путь к директории: ");
        String directoryPath = scanner.nextLine();

        List<File> textFiles = getTextFiles(directoryPath);
        if (textFiles.isEmpty()) {
            System.out.println("По указанному пути нет текстовых файлов");
            return;
        }

        Map<String, Integer> resultMap = new ConcurrentHashMap<>();
        ISearchEngine caseInsensitive = new SearchEngineCaseInsensitive(new EasySearch());
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            while (true) {
                printFileList(textFiles);
                System.out.println("Введите слово для поиска (или 'exit' для завершения): ");
                String searchWord = scanner.nextLine();

                if (searchWord.equalsIgnoreCase("exit")) {
                    break;
                }

                processFiles(textFiles, resultMap, caseInsensitive, searchWord, executorService);
            }
        } finally {
            executorService.shutdown();
            writeResultsToFile(resultMap);
        }
    }

    public static void processFiles(List<File> textFiles, Map<String, Integer> resultMap,
                                    ISearchEngine punctuationNormalize, String searchWord, ExecutorService executorService) {
        List<Future<?>> futures = new ArrayList<>();

        for (File file : textFiles) {
            Callable<Void> task = () -> {
                long wordCount = punctuationNormalize.search(getFileContent(file), searchWord);
                String key = String.format("%s - %s - %d", file.getName(), searchWord, wordCount);
                resultMap.put(key, (int) wordCount); // Приводим значение long к int
                System.out.println(key);
                return null;
            };

            futures.add(executorService.submit(task));
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    static void printFileList(List<File> textFiles) {
        System.out.println("Список файлов: ");
        for (int i = 0; i < textFiles.size(); i++) {
            System.out.println((i + 1) + "." + textFiles.get(i).getName());
        }
    }

    public static List<File> getTextFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        return files != null ? Arrays.asList(files) : Collections.emptyList();
    }

    static String getFileContent(File file) {
        try (Scanner fileScanner = new Scanner(file)) {
            StringBuilder content = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
            return content.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден");
            return "";
        }
    }

    public static void writeResultsToFile(Map<String, Integer> resultMap) {
        // Вывод результатов в консоль и запись в файл
        System.out.println("Результаты поиска:");

        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true))) {
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                String resultString = entry.getKey();
                System.out.println(resultString);
                writer.println(resultString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
