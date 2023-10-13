package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMemory {
    private ICalculator calculator;
    private double memory;

    public CalculatorWithMemory(ICalculator calculator) {
        this.calculator = calculator;
        this.memory = 0.0;
    }

    public double add(double a, double b) {
        double result = calculator.add(a, b);
        memory = result;
        return result;
    }


    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        memory = result;
        return result;
    }


    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        memory = result;
        return result;
    }


    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        memory = result;
        return result;
    }


    public double exponent(double base, int exponent) {
        double result = calculator.exponent(base, exponent);
        memory = result;
        return result;
    }


    public double absolute(double a) {
        double result = calculator.absolute(a);
        memory = result;
        return result;
    }

    public double square(double a) {
        double result = calculator.square(a);
        memory = result;
        return result;
    }

    public void save() {
        memory = getResult();
    }

    public double load() {
        double value = memory;
        memory = 0.0;
        return value;
    }

    private double getResult() {
        return memory;
    }
}
