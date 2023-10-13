package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithCounterAutoDecorator implements ICalculator {
    private ICalculator calculator;
    private int operationCount;

    public CalculatorWithCounterAutoDecorator(ICalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double add(double a, double b) {
        operationCount++;
        return calculator.add(a, b);
    }

    @Override
    public double exponent(double base, int exponent) {
        operationCount++;
        return calculator.exponent(base, exponent);
    }

    @Override
    public double absolute(double a) {
        operationCount++;
        return calculator.absolute(a);
    }

    @Override
    public double square(double a) {
        operationCount++;
        return calculator.square(a);
    }

    @Override
    public double subtract(double a, double b) {
        operationCount++;
        return calculator.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        operationCount++;
        return calculator.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        operationCount++;
        return calculator.divide(a, b);
    }

    public int getOperationCount() {
        return operationCount;
    }
}
