package home_work_5.person.Name;

import java.util.Random;

public class RandomRussianString {
    public static String radomRussianRenerationString (int length){
        String characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕËЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        StringBuilder randomRussianString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(characters.length());
            randomRussianString.append(characters.charAt(index));
        }
        return randomRussianString.toString();
    }
}
