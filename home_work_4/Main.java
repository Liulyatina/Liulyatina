package home_work_4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        DataContainer<String> stringContainer = new DataContainer<>(String.class, 20);
        stringContainer.add("i");
        stringContainer.add("hello");
        stringContainer.add("1");
        stringContainer.add("Как домашка");

        // Сортировка строк по длине
        stringContainer.sort(new StringLengthComparator());
        System.out.println(Arrays.toString(stringContainer.getItems())); // ["i", "1", "hello", "Как домашка"]

    }
}

