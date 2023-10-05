package Home_work_1.Checker;

public class LeapYearChecker {
    public static void main(String[] args) {
        int year = 2024; // Замените на интересующий вас год

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (isLeapYear) {
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - не високосный год");
        }
    }
}