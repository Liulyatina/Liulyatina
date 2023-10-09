package home_work_2.Cycle;

import java.util.Scanner;


public class MultiplyDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        String input = scanner.nextLine();

        if (isInteger(input)) {
            int result = multiplyDigits(input);
            System.out.println("Произведение цифр числа " + input + " = " + result);
        } else {
            System.out.println("Введено не целое число.");
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int multiplyDigits(String input) {
        int result = 1;

        System.out.print("Ход вычислений: ");

        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            if (Character.isDigit(digitChar)) {
                int digit = digitChar - '0'; // Преобразование символа цифры в целое число

                if (i < input.length() - 1) {
                    System.out.print(digit + " * ");
                } else {
                    System.out.print(digit + " = ");
                }

                result *= digit;
            } else {
                System.out.println("Введено не число.");
                return 0;
            }
        }

        return result;
    }
}


