package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathCopy;

public class CalculatorWithCounterAutoComposite {
    private CalculatorWithMathCopy calculator;
    private long countOperation;

    public CalculatorWithCounterAutoComposite() {
        this.calculator = new CalculatorWithMathCopy();
        this.countOperation = 0;
    }

    public double add(double a, double b) {
        countOperation++;
        return calculator.add(a, b);
    }

    public double subrtact(double a, double b) {
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

    public double exponent(double base, int exponent) {
        countOperation++;
        return calculator.exponent(base, exponent);
    }

    public double absolute(double a) {
        countOperation++;
        return calculator.absolute(a);
    }

    public double square(double a) {
        countOperation++;
        return calculator.square(a);
    }

    public long getCountOperation() {
        return countOperation;
    }
}
