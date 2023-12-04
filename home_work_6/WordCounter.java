package home_work_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {

        Set<String> wordCount = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Война_и_мир_книга.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCount.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Количество использованных слов : " + wordCount.size());
    }
}