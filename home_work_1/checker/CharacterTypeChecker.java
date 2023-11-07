package home_work_1.checker;

public class CharacterTypeChecker {

    public static String letterOrSymbol(char character) {

        if (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z') {
            return "Вы ввели букву: " + character;
        }
        return "Вы ввели символ: " + character;
    }

}