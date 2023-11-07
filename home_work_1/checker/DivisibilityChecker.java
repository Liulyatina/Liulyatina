package home_work_1.checker;

public class DivisibilityChecker {
    public static boolean divisionCheck(int dividend, int divider) {
        if (divider == 0) {
            throw new IllegalArgumentException("Divider cannot be 0");
        }

        return (dividend % divider == 0);
    }
}
