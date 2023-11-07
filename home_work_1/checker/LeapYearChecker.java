package home_work_1.checker;

public class LeapYearChecker {
    public static void main(String[] args) {
        System.out.println(isLeapYear(0));
    }
        public static boolean isLeapYear(int year) {

            if (year > 0) {

                return year % 4 == 0;
            }
            return false;
        }
    }
