package home_work_3.calcs.runners;

import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        CalculatorWithMathCopy calculator = new CalculatorWithMathCopy();
        double result = calculator.add(calculator.add(4.1, calculator.multiply(15, 7)), Math.pow(calculator.divide(28, 5), 2));
        System.out.println(result);
    }
}
