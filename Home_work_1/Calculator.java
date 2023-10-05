package Home_work_1;

public class Calculator {
    public static void main(String[] args) {
        int a = 8;
        int b = 8;

        // 2.1
        int result1 = 5 + a / b;
        System.out.println("2.1: " + result1); // Результат: 5

        // 2.2
        int result2 = (5 + a) / b;
        System.out.println("2.2: " + result2); // Результат: 0

        // 2.3
        // int result3 = (5 + a++) / b; // Ошибка компиляции

        // 2.4
        int result4 = (5 + a++) / --b;
        System.out.println("2.4: " + result4); // Результат: 1

        // 2.5
        int result5 = (5 * 2 >> a++) / --b;
        System.out.println("2.5: " + result5); // Результат: 0

        // 2.6
        int result6 = (5 + 7 > 20 ? 68 : 22 * 2 >> a++) / --b;
        System.out.println("2.6: " + result6); // Результат: 1

        // 2.7
        // int result7 = (5 + 7 > 20 ? 68 >= 68 : 22 * 2 >> a++) / --b; // Ошибка компиляции

        // 2.8
        boolean result8 = 6 - 2 > 3 && 12 * 12 <= 119;
        System.out.println("2.8: " + result8); // Результат: false

        // 2.9
        boolean result9 = true && false;
        System.out.println("2.9: " + result9); // Результат: false
    }
}
