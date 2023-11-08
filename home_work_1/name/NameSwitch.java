package home_work_1.name;

import java.util.Scanner;

public class NameSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();
        if (message != null) {
            System.out.println(sen(message));
        }
        scanner.close();
    }

    public static String sen(String message) {
        switch (message) {
            case "Вася":
                System.out.println("Привет!\nЯ тебя так долго ждал");
                break;
            case "Анастасия":
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
        }
        return message;
    }
}

