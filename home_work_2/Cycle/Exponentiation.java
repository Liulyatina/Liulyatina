package home_work_2.Cycle;

import java.util.Scanner;

public class Exponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        double num = scanner.nextDouble();
        System.out.println("Введите показатель степени: ");
        int exponent = scanner.nextInt();
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
         result *= num;
        }
        System.out.println(num+" ^ "+exponent+" = "+result);
    }
}
