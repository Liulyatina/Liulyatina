import home_work_2.Arrays.ArraysUtils;
import home_work_2.Arrays.IArraysOperation;

public class Main {

    public static void main(String[] args) {
        int[] container = ArraysUtils.arrayFromConsole();
        int[] container1 = ArraysUtils.arrayRandom(5, 100);
        System.out.println("Массив с консоли: ");
        for (int num : container) {
            System.out.println(num + " ");
        }
        System.out.println("\nМассив с рандомными числами: ");
        for (int num : container1) {
            System.out.println(num + " ");
        }
    }
}
