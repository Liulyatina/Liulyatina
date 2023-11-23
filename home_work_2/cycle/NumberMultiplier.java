package home_work_2.cycle;

public class NumberMultiplier {
    public static int multiplyDigitsInNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                System.out.println("Введено отрицательное число.");
                return -1;
            }

            int result = 1;
            String numberStr = Integer.toString(number);
            for (int i = 0; i < numberStr.length(); i++) {
                int digit = Character.getNumericValue(numberStr.charAt(i));
                System.out.print(digit);
                result *= digit;
                if (i < numberStr.length() - 1) {
                    System.out.print(" * ");
                }
            }
            System.out.println(" = " + result);

            return result;
        } catch (NumberFormatException e) {
            System.out.println("Введено не целое число.");
            return -1;
        }
    }
}
