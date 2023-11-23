package home_work_2.cycle;

public class MultiplyDigits {
    public static void main(String[] args) {
        System.out.println(calculateFactorialWithLoop(5));
    }
    public static long calculateFactorialWithLoop(int n) {
        if (n < 0) {
            System.out.println("Введено отрицательное число.");
            return -1;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


