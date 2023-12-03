package home_work_6.searchApp;

import home_work_6.ISearchEngine;
import home_work_6.search.RegExSearch;
import home_work_6.search.SearchEnginePunctuationNormalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<File> textFiles = getTextFiles("/Users/romamihalevic/IdeaProjects/Home_work/src/Books");
        if (textFiles.isEmpty()) {
            System.out.println("По указанному пути нет текстовых файлов");
            return;
        }

        Map<String, Integer> resultMap = new HashMap<>();
        ISearchEngine punctuationNormalize = new SearchEnginePunctuationNormalizer(new RegExSearch());

        while (true) {
            printFileList(textFiles);
            System.out.println("Выберите номер файла (введите 'exit' для завершения): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            processFile(textFiles, resultMap, punctuationNormalize, userInput, scanner);
        }
    }

    private static void processFile(List<File> textFiles, Map<String, Integer> resultMap,
                                    ISearchEngine punctuationNormalize, String userInput, Scanner scanner) {
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

                long wordCount = punctuationNormalize.search(getFileContent(selectedFile), searchWord);
                String key = String.format("%s - %s", selectedFile.getName(), searchWord);
                resultMap.put(key, (int) wordCount);
                System.out.println("Результат поиска: " + wordCount);
            }

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Некорректный номер. Введите номер из списка: ");
        }
    }

    private static void printFileList(List<File> textFiles) {
        System.out.println("Список файлов: ");
        for (int i = 0; i < textFiles.size(); i++) {
            System.out.println((i + 1) + "." + textFiles.get(i).getName());
        }
    }

    private static List<File> getTextFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        return files != null ? Arrays.asList(files) : Collections.emptyList();
    }

    private static String getFileContent(File file) {
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
}
