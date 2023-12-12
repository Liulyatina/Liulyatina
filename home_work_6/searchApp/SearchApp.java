package home_work_6.searchApp;

import home_work_6.ISearchEngine;
import home_work_6.search.EasySearch;
import home_work_6.search.SearchEngineCaseInsensitive;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SearchApp {
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

        Map<String, Integer> resultMap = new HashMap<>();
        ISearchEngine searchEngine = new SearchEngineCaseInsensitive(new EasySearch());

        while (true) {
            printFileList(textFiles);
            System.out.println("Выберите номер файла (введите 'exit' для завершения): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            processFile(textFiles, resultMap, searchEngine, userInput, scanner);
        }
    }

    public static void processFile(List<File> textFiles, Map<String, Integer> resultMap,
                                   ISearchEngine searchEngine, String userInput, Scanner scanner) {
        try {
            int fileIndex = Integer.parseInt(userInput) - 1;
            File selectedFile = textFiles.get(fileIndex);

            while (true) {
                System.out.println("Введите слово для поиска в файле " + selectedFile.getName() +
                        " (введите 'exit' для возврата к списку файлов):");
                String searchWord = scanner.nextLine();

                if (searchWord.equalsIgnoreCase("exit")) {
                    break;  // Возврат к списку файлов
                }

                long wordCount = searchEngine.search(getFileContent(selectedFile), searchWord);
                String key = String.format("%s - %s", selectedFile.getName(), searchWord);
                resultMap.put(key, (int) wordCount);
                System.out.println("Результат поиска: " + wordCount);
                writeResultsToFile(resultMap, "result.txt");
            }

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Некорректный номер. Введите номер из списка: ");
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
        try (Scanner fileScanner = new Scanner(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
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
    public static void writeResultsToFile(Map<String, Integer> resultMap, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, StandardCharsets.UTF_8)) {
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
