package home_work_6.searchApp;

import home_work_6.ISearchEngine;
import home_work_6.search.EasySearch;
import home_work_6.search.SearchEngineCaseInsensitive;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadSearchApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // /Users/romamihalevic/IdeaProjects/Home_work/src/Books
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

    public static List<Future<Void>> processFiles(List<File> files, Map<String, Integer> resultMap, ISearchEngine searchEngine, String target, ExecutorService executorService) {
        List<Future<Void>> futures = new ArrayList<>();

        for (File file : files) {
            futures.add(executorService.submit(() -> {
                try {
                    // Явно указываем кодировку (например, UTF-8)
                    String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    int occurrences = (int) searchEngine.search(content, target);
                    String key = file.getName() + " - " + target;
                    resultMap.merge(key, occurrences, Integer::sum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }));
        }

        // Ждем завершения всех задач
        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return futures;
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

//    static String getFileContent(File file) {
//        try (Scanner fileScanner = new Scanner(file)) {
//            StringBuilder content = new StringBuilder();
//            while (fileScanner.hasNextLine()) {
//                content.append(fileScanner.nextLine()).append("\n");
//            }
//            return content.toString();
//        } catch (FileNotFoundException e) {
//            System.out.println("Ошибка: файл не найден");
//            return "";
//        }
//    }

    public static void writeResultsToFile(Map<String, Integer> resultMap) {
        // Вывод результатов в консоль и запись в файл
        System.out.println("Результаты поиска:");

        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true))) {
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                String resultString = entry.getKey() + " - " + entry.getValue();
                System.out.println(resultString);
                writer.println(resultString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
