package home_work_2.cycle;

public class MultiplyNumbersWithRecursion {
    public static void main(String[] args) {
        System.out.println(calculateFactorialWithRecursion(5));
    }
    public static long calculateFactorialWithRecursion(int n) {
        if (n < 0) {
            System.out.println("Введено отрицательное число.");
            return -1;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * calculateFactorialWithRecursion(n - 1);
    }
}
