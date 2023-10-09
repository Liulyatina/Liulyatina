package home_work_2.Cycle;

import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите не отрицательное число ");
        int count = scanner.nextInt();
        if (count < 0) {
            System.out.println("Вы ввели отрицательное число");
        } else {
            long result = 1;
            for (int i = 1; i <= count; i++) {
                System.out.println("Введите число " + i + " : ");
                int num = scanner.nextInt();
                result *= num;


            }
            System.out.println("Произведение из " + count + " чисел, равно : " + result);
        }
    }
}
