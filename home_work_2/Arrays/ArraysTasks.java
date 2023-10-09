package home_work_2.Arrays;

import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayRandom(5, 100);
        System.out.println("Сумма четных положительных элементов массива: " + sumOfEvenElements(array));
        System.out.println("Максимальный из элементов массива с четными индексами: " + maxOfEvenElements(array));
        System.out.println("Два наименьших (минимальных) элемента массива: " + Arrays.toString(findTwoSmallestElement(array)));
        System.out.println("Сумма цифр массива: " + sumOfDigitsInArray(array));
    }

    public static int sumOfEvenElements(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num > 0 && num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int maxOfEvenElements(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int[] findTwoSmallestElement(int[] array) {
        int[] result = new int[2];
        Arrays.sort(array);
        result[0] = array[1];
        result[1] = array[0];
        return result;
    }

    public static int sumOfDigitsInArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            num += sumOfDigit(num);
        }
        return sum;
    }

    private static int sumOfDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
