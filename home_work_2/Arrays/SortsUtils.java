package home_work_2.Arrays;

public class SortsUtils {
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Обмен элементов, если они находятся в неправильном порядке
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void shake(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        do {
            for (int i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    // Обмен элементов, если они находятся в неправильном порядке
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
            left++;

            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Обмен элементов, если они находятся в неправильном порядке
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;
        } while (left <= right);
    }
}
