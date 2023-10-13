package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemoryDecorator implements ICalculator {
    private ICalculator calculator;
    private double memory;

    public CalculatorWithMemoryDecorator(ICalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double add(double a, double b) {
        double result = calculator.add(a, b);
        saveLastResult(result);
        return result;
    }

    @Override
    public double exponent(double base, int exponent) {
        double result = calculator.exponent(base, exponent);
        saveLastResult(result);
        return result;
    }

    @Override
    public double absolute(double a) {
        double result = calculator.absolute(a);
        saveLastResult(result);
        return result;
    }

    @Override
    public double square(double a) {
        double result = calculator.square(a);
        saveLastResult(result);
        return result;
    }

    @Override
    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        saveLastResult(result);
        return result;
    }

    @Override
    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        saveLastResult(result);
        return result;
    }

    @Override
    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        saveLastResult(result);
        return result;
    }

    public void saveLastResult(double result) {
        memory = result;
    }

    public double getMemory() {
        return memory;
    }
}
