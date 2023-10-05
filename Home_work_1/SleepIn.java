package Home_work_1;

public class SleepIn {
    public static void main(String[] args) {
        boolean isWeekday = false; // Замените на true, если сегодня рабочий день
        boolean isVacation = true; // Замените на true, если у вас отпуск

        if (sleepIn(isWeekday, isVacation)) {
            System.out.println("Можем спать дальше!");
        } else {
            System.out.println("Пора идти на работу!");
        }
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
}
