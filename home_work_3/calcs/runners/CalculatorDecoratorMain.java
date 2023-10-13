package home_work_3.calcs.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoDecorator;

import home_work_3.calcs.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorDecoratorMain {
    public static void main(String[] args) {
        ICalculator calc = new CalculatorWithCounterAutoDecorator(new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()));

        // Выполнение вычислений
        double result1 = calc.add(4.1, 15 * 7);
        double result2 = calc.divide(28, 5);

        System.out.println("Результаты вычислений:");
        System.out.println("4.1 + 15 * 7 = " + result1);
        System.out.println("28 / 5 = " + result2);

        // Вывод количества операций
        if (calc instanceof CalculatorWithCounterAutoDecorator) {
            int operationCount = ((CalculatorWithCounterAutoDecorator) calc).getOperationCount();
            System.out.println("Количество операций: " + operationCount);
        }

        // Вывод значения в памяти
        if (calc instanceof CalculatorWithMemoryDecorator) {
            CalculatorWithMemoryDecorator memoryCalculator = (CalculatorWithMemoryDecorator) calc;
            double memoryValue = memoryCalculator.getMemory();
            System.out.println("Значение в памяти: " + memoryValue);
        }
    }
}



