package home_work_1.bitOperatiom;

import java.util.Scanner;

public class BitwiseOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вводим два числа через консоль
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        // Пример двоичного представления чисел (8 бит):
        System.out.println("Первое число (в двоичной системе): " + Integer.toBinaryString(num1));
        System.out.println("Второе число (в двоичной системе): " + Integer.toBinaryString(num2));
    }

    public static String bitwiseOperatorAnd(int num1, int num2) { // Число one 12 (1100), число two 13 (1101)

        int and = num1 & num2;
        return Integer.toBinaryString(and);
    }

    public static String bitwiseOperatorOr(int num1, int num2) {

        int or = num1 | num2;
        return Integer.toBinaryString(or);

    }
}

