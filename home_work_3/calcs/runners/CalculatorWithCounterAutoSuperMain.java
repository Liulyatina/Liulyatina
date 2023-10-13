package home_work_3.calcs.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

public class CalculatorWithCounterAutoSuperMain {
    public static void main(String[] args) {
        CalculatorWithCounterAutoSuper calculator = new CalculatorWithCounterAutoSuper();
        double result1 = calculator.add(4.1, calculator.multiply(15, 7));
        double result2 = calculator.exponent(calculator.divide(28, 5), 2);

        double finalResult = calculator.add(result1, result2);
        System.out.println("Результат: " + finalResult);
        System.out.println("Количество операциы: " + calculator.getCountOperation());
    }
}
