package Home_work_1.Checker;

public class CharacterTypeChecker {
    public static void main(String[] args) {
        char symbol = 'A'; // Замените на символ

        if (Character.isLetter(symbol)) {
            System.out.println(symbol + " - это буква");
        } else {
            System.out.println(symbol + " - это иной символ");
        }
    }
}