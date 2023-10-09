package home_work_2.Arrays;

import java.util.Arrays;

public class SortsMain {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        testSort("array1", array1);

        int[] array2 = new int[]{1, 1, 1, 1};
        testSort("array2", array2);

        int[] array3 = new int[]{9, 1, 5, 99, 9, 9};
        testSort("array3", array3);

        int[] array4 = new int[]{};
        testSort("array4", array4);

        int[] array5 = new int[]{6, 5, 4, 3, 2, 1};
        testSort("array5", array5);

        // Тест с рандомно заполненным массивом
        int[] randomArray = ArraysUtils.arrayRandom(50, 100);
        testSort("randomArray", randomArray);

        // Тест с массивом, введенным через консоль
        int[] consoleArray = ArraysUtils.arrayFromConsole();
        testSort("consoleArray", consoleArray);
    }

    public static void testSort(String arrayName, int[] array) {
        System.out.println("Before sorting: " + arrayName + " -> " + Arrays.toString(array));

        // Вызываем метод сортировки (например, SortsUtils.sort или SortsUtils.shake)
        // В данном случае, используется сортировка пузырьком
        SortsUtils.sort(array);

        System.out.println("After sorting: " + arrayName + " -> " + Arrays.toString(array));
    }
}

