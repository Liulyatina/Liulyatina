package home_work_3.calcs.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoAgregation;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithCounterDelegateAgregationMain {
    public static void main(String[] args) {
        CalculatorWithMathCopy realCalculator = new CalculatorWithMathCopy();
        CalculatorWithCounterAutoAgregation calculator = new CalculatorWithCounterAutoAgregation(realCalculator);
        double result1 = calculator.add(4.1, calculator.multiply(15, 7));
        double result2 = calculator.exponent(calculator.divide(28, 5), 2);

        double finalResult = calculator.add(result1, result2);
        System.out.println("Результат: " + finalResult);
        System.out.println("Количество операциы: " + calculator.getCountOperation());
    }
}
