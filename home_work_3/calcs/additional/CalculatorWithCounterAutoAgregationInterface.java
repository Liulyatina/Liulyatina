package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoAgregationInterface {
    private ICalculator calculator;
    private long countOperation;

    public CalculatorWithCounterAutoAgregationInterface(ICalculator calculator) {
        this.calculator = calculator;
        this.countOperation = 0;
    }

    public double add(double a, double b) {
        countOperation++;
        return calculator.add(a, b);
    }


    public double subtract(double a, double b) {
        countOperation++;
        return calculator.subtract(a, b);
    }


    public double multiply(double a, double b) {
        countOperation++;
        return calculator.multiply(a, b);
    }


    public double divide(double a, double b) {
        countOperation++;
        return calculator.divide(a, b);
    }


    public double power(double base, int exponent) {
        countOperation++;
        return calculator.exponent(base, exponent);
    }


    public double abs(double a) {
        countOperation++;
        return calculator.absolute(a);
    }


    public double sqrt(double a) {
        countOperation++;
        return calculator.square(a);
    }

    public long getCountOperation() {
        return countOperation;
    }
}

