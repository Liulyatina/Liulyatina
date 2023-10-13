package home_work_3.calcs.runners;

import home_work_3.calcs.additional.CalculatorWithMemory;
import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithMemoryMain {
    public static void main(String[] args) {
        CalculatorWithMemory calcMemory = new CalculatorWithMemory(new CalculatorWithOperator());
        calcMemory.divide(28, 5);
        calcMemory.save();
        calcMemory.exponent(calcMemory.load(), 2);
        calcMemory.save();
        calcMemory.add(4.1, calcMemory.load());
        calcMemory.save();
        calcMemory.add(calcMemory.load(), calcMemory.multiply(15, 7));
        System.out.printf("%.2f%n", calcMemory.load()); // Выведет 140.46
    }
}
