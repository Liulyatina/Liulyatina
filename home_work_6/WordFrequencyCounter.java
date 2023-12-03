package home_work_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Война_и_мир_книга.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word :
                        words) {
                        word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
                        wordFrequencyMap.merge(word.toLowerCase(), 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordFrequencyMap.remove("");
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequencyMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int top = 10;
        System.out.println("Топ " + top + " слов:");
        for (int i = 0; i < top && i < sortedList.size(); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + "-" + entry.getValue() + "раз");
        }
    }
}

