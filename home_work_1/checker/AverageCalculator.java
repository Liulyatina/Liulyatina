package home_work_1.checker;

public class AverageCalculator {
    public static int middleOfThreeDigit(int num1, int num2, int num3) {

        if (num1 < num2 && num1 > num3 || num1 > num2 && num1 < num3) {
            return num1;

        } else if (num2 < num1 && num2 > num3 || num2 > num1 && num2 < num3) {
            return num2;
        }
        return num3;
    }
}
