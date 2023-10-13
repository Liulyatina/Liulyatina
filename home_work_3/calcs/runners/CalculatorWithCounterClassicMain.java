package home_work_3.calcs.runners;

import home_work_3.calcs.additional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calculator = new CalculatorWithCounterClassic();
        double result = calculator.add(calculator.add(4.1, calculator.multiply(15, 7)), calculator.exponent(calculator.divide(28.0, 5), 2));
        long count = calculator.getCountOperation();
        System.out.println("Результат: " + result + "\nКоличество операции: " + count);
    }
}
