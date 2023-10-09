package home_work_1;

import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) {
        int[] phoneNumberArray = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Введите цифру " + (i + 1) + " : ");
            phoneNumberArray[i] = scanner.nextInt();
        }
        String formattedPhoneNumber = createPhoneNumber(phoneNumberArray);
        System.out.println(formattedPhoneNumber);

    }

    public static String createPhoneNumber(int[] numbers) {
        String phoneNumber = String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);

        return phoneNumber;
    }
}
