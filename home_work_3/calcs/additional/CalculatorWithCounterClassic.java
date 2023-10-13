package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterClassic extends CalculatorWithMathExtends {
    private long countOperation = 0;

    public void incrementCountOperation() {
        countOperation++;
    }

    public long getCountOperation() {
        return countOperation;
    }

    @Override
    public double exponent(double base, int exponent) {
        incrementCountOperation();
        return super.exponent(base, exponent);
    }

    @Override
    public double absolute(double a) {
        incrementCountOperation();
        return super.absolute(a);
    }

    @Override
    public double square(double a) {
        incrementCountOperation();
        return super.square(a);
    }

    @Override
    public double add(double a, double b) {
        incrementCountOperation();
        return super.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        incrementCountOperation();
        return super.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        incrementCountOperation();
        return super.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        incrementCountOperation();
        return super.divide(a, b);
    }
}
