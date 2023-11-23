package home_work_2.arrays;

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
        int maxValue = 0;

        for (int i = 0; i < array.length; i++) {

            if ((i % 2 == 0) && array[i] > maxValue) {

                maxValue = array[i];
            }
        }

        return maxValue;
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

        for (int i = 0; i < array.length; i++) {

            int number = array[i];

            while (number > 0) {

                sum += number % 10;
                number /= 10;
            }
        }

        return sum;
    }
}
