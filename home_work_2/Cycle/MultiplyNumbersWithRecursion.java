package home_work_2.Cycle;
import java.util.Scanner;

import java.util.Scanner;

public class MultiplyNumbersWithRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел для умножения: ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("Введите положительное число для количества чисел.");
        } else {
            int product = multiplyNumbersRecursive(count);
            System.out.println("Произведение введенных чисел: " + product);
        }
    }

    public static int multiplyNumbersRecursive(int n) {
        if (n == 1) {
            System.out.print("Введите число #1: ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            return num;
        } else {
            System.out.print("Введите число #" + n + ": ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            return num * multiplyNumbersRecursive(n - 1);
        }
    }
}
