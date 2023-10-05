package Home_work_1.Checker;

public class DivisibilityChecker {
    public static void main(String[] args) {
        int dividend = 15;
        int divisor = 5;

        if (dividend % divisor == 0) {
            System.out.println(dividend + " делится на " + divisor);
        } else {
            System.out.println(dividend + " не делится на " + divisor);
        }
    }
}
