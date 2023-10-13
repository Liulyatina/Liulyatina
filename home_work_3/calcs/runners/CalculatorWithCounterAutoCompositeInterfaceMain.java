package home_work_3.calcs.runners;

import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.additional.CalculatorWithCounterAutoAgregationInterface;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterAutoCompositeInterfaceMain {
    public static void main(String[] args) {
        ICalculator calculator = new CalculatorWithOperator();
        CalculatorWithCounterAutoAgregationInterface calc = new CalculatorWithCounterAutoAgregationInterface(calculator);
        double result = calc.add(calc.add(4.1, calc.multiply(15, 7)), calc.power(calc.divide(28, 5), 2));
        System.out.println("Результат: " + result);
        System.out.println("Количество операциы: " + calc.getCountOperation());
    }
}
