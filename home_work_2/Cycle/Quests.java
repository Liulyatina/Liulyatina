package home_work_2.Cycle;

import java.util.Scanner;

public class Quests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1.5.1. Найти наибольшую цифру натурального числа
        System.out.print("Введите натуральное число для поиска наибольшей его цифры: ");
        long num1 = scanner.nextLong();
        int largest1 = findLargestDigit(num1);
        System.out.println("Наибольшая цифра: " + largest1);

        // 1.5.2. Вероятность четных случайных чисел
        System.out.print("Введите общее количество чисел для определения вероятности четных чисел: ");
        int totalNumbers = scanner.nextInt();
        double probability = evenProbability(totalNumbers);
        System.out.println("Вероятность четных чисел: " + probability);

        // 1.5.3. Посчитать четные и нечетные цифры числа
        System.out.print("Введите число для подсчёта чётных и нечетных цифр числа: ");
        long num2 = scanner.nextLong();
        evenAndOddDigit(num2);

        // 1.5.4. Ряд Фибоначчи
        System.out.print("Введите количество чисел в ряде Фибоначчи: ");
        int n = scanner.nextInt();
        printFibonacci(n);

        // 1.5.5. Вывести ряд чисел в диапазоне с шагом
        System.out.print("Введите начало диапазона: ");
        int start = scanner.nextInt();
        System.out.print("Введите конец диапазона: ");
        int end = scanner.nextInt();
        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();
        printSeriesWithStep(start, end, step);

        // 1.5.6. Переворот числа
        System.out.print("Введите число для переворота: ");
        long num3 = scanner.nextLong();
        long reversedNum = reverseNumber(num3);
        System.out.println("Перевернутое число: " + reversedNum);
    }

    public static int findLargestDigit(long number) {
        int largestDigit = 0;
        while (number > 0) {
            int digit = (int) (number % 10);
            if (digit > largestDigit) {
                largestDigit = digit;
            }
            number /= 10;
        }
        return largestDigit;
    }
    public static double evenProbability(int totalNumber){
        int evenCount = totalNumber/2;
        return (double) evenCount/totalNumber;
    }
    public static void evenAndOddDigit(long number){
        int evenCount = 0;
        int oddCount = 0;
        while (number>0){
            int digit = (int)(number%10);
            if(digit%2==0){
                evenCount++;
            }else{
                oddCount++;
            }
            number/=10;
        }
        System.out.println("Вывод количества четных цифр в числе "+evenCount);
        System.out.println("Вывод количества нечётных цифр в чилсе "+oddCount);
    }
    public static void printFibonacci (int n){
        System.out.print("Введите количество чисел в ряде Фибоначчи: ");
        int a = 0;
        int b = 1;
        System.out.println("Ряд Фибоначчи: "+a+" "+b);
        for (int i = 2; i<n; i++){
            int c = a + b;
            System.out.println(" "+c);
            a = b;
            b = c;
        }
        System.out.println();
    }
    public static void printSeriesWithStep(int start, int end, int step){
        System.out.println("Ряд чисел: ");
        for (int i=start;i<end;i+=step){
            System.out.println(i+" ");
        }
        System.out.println();
    }
    public static long reverseNumber(long number) {
        long reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }
}
