package home_work_1;

public class SleepIn {
    public static void main(String[] args) {
        boolean isWeekday = false; // Замените на true, если сегодня рабочий день
        boolean isVocation = true; // Замените на true, если у вас отпуск

        System.out.println(printAnswer(isWeekday, isVocation));
    }
    public static String printAnswer(boolean weekday,boolean vocation){
        return sleepIn(weekday, vocation) ? "Можно спать дальше!" : "Пора идти на работу!";
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
}
