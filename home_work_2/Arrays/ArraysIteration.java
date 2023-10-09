package home_work_2.Arrays;

public class ArraysIteration {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayFromConsole();
        System.out.println("Все элементы массива: ");
        iterateWithFor(array);
        iterateWithWhile(array);
        iterateWithDoWhile(array);
        iterateWithForEach(array);
        System.out.println("Каждый второй элемент: ");
        iterateSecondElement(array);
        System.out.println("Массив в обратном порядке: ");
        iterateReverse(array);

    }

    public static void iterateWithFor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    public static void iterateWithWhile(int[] array) {
        int i = 0;
        while (i < array.length) {
            System.out.println(array[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static void iterateWithDoWhile(int[] array) {
        int i = 0;
        do {
            System.out.println(array[i] + " ");
            i++;
        } while (i < array.length);
        System.out.println();
    }

    public static void iterateWithForEach(int[] array) {
        for (int num : array) {
            System.out.println(num + " ");
        }
        System.out.println();
    }

    public static void iterateSecondElement(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    public static void iterateReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
