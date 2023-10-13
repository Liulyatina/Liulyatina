package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {
    private long countOperation;

    public CalculatorWithCounterAutoSuper() {
        this.countOperation = 0;
    }

    @Override
    public double add(double a, double b) {
        countOperation++;
        return super.add(a, b);
    }

    public double subrtact(double a, double b) {
        countOperation++;
        return super.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        countOperation++;
        return super.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        countOperation++;
        return super.divide(a, b);
    }

    @Override
    public double exponent(double base, int exponent) {
        countOperation++;
        return super.exponent(base, exponent);
    }

    @Override
    public double absolute(double a) {
        countOperation++;
        return super.absolute(a);
    }

    @Override
    public double square(double a) {
        countOperation++;
        return super.square(a);
    }

    public long getCountOperation() {
        return countOperation;
    }
}
