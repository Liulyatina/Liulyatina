package home_work_1.name;

import java.util.Scanner;

public class NameIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();
        System.out.println(sen(message));
        scanner.close();
    }

    public static String sen(String message) {


        if (message != null && message.equals("Вася")) {
            return "Привет!\nЯ тебя так долго ждал";
        } else if (message != null && message.equals("Анастасия")) {
            return "Я тебя так долго ждал";
        }
        return "Добрый день, а вы кто?";
    }
}



