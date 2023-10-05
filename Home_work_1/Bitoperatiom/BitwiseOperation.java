package Home_work_1.Bitoperatiom;

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

        // Побитовая операция И
        int resultAnd = num1 & num2;
        System.out.println("Результат операции И: " + Integer.toBinaryString(resultAnd));

        // Побитовая операция ИЛИ
        int resultOr = num1 | num2;
        System.out.println("Результат операции ИЛИ: " + Integer.toBinaryString(resultOr));
    }
}
