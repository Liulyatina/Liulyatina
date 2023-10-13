package home_work_3.calcs.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoChoiceAgregation;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithCounterDelegateChoiceAgregationMain {
    public static void main(String[] args) {
        CalculatorWithOperator calculator1 = new CalculatorWithOperator();
        CalculatorWithMathCopy calculator2 = new CalculatorWithMathCopy();
        CalculatorWithMathExtends calculator3 = new CalculatorWithMathExtends();
        CalculatorWithCounterAutoChoiceAgregation calc1 = new CalculatorWithCounterAutoChoiceAgregation(calculator1);
        CalculatorWithCounterAutoChoiceAgregation calc2 = new CalculatorWithCounterAutoChoiceAgregation(calculator2);
        CalculatorWithCounterAutoChoiceAgregation calc3 = new CalculatorWithCounterAutoChoiceAgregation(calculator3);
        double result1 = calc1.add(calc1.add(4.1, calc1.multiply(15, 7)), calc1.power(calc1.divide(28, 5), 2));
        double result2 = calc2.add(calc2.add(4.1, calc2.multiply(15, 7)), calc2.power(calc2.divide(28, 5), 2));
        double result3 = calc3.add(calc3.add(4.1, calc3.multiply(15, 7)), calc3.power(calc3.divide(28, 5), 2));
        System.out.println("Результат для CalculatorWithOperator: " + result1);
        System.out.println("Количество операций для CalculatorWithOperator: " + calc1.getCountOperation());

        System.out.println("Результат для CalculatorWithMathCopy: " + result2);
        System.out.println("Количество операций для CalculatorWithMathCopy: " + calc2.getCountOperation());

        System.out.println("Результат для CalculatorWithMathExtends: " + result3);
        System.out.println("Количество операций для CalculatorWithMathExtends: " + calc3.getCountOperation());
    }
}

