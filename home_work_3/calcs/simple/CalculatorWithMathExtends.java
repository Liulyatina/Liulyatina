package home_work_3.calcs.simple;

import home_work_3.calcs.api.ICalculator;

public class CalculatorWithMathExtends extends CalculatorWithOperator implements ICalculator {
    @Override
    public double exponent(double base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Отрицательная степень не поддерживается");
        }
        return Math.pow(base, exponent);
    }

    @Override
    public double absolute(double a) {
        return Math.abs(a);
    }

    @Override
    public double square(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Корень из отрицательного чесла недопустим");
        }
        return Math.sqrt(a);
    }
}
