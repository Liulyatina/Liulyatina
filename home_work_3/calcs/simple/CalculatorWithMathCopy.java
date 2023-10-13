package home_work_3.calcs.simple;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMathCopy implements ICalculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        return a / b;
    }

    public double exponent(double base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Отрицательная степень не поддерживается");
        }
        return Math.pow(base,exponent);
    }

    public double absolute(double a) {
        return Math.abs(a);
    }

    public double square(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Корень из отрицательного чесла недопустим");
        }
        return Math.sqrt(a);
    }
}
