package test.home_work_3_test;

import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorsTest {

    ICalculator mathCopy = new CalculatorWithMathCopy();
    ICalculator mathExtends = new CalculatorWithMathExtends();
    ICalculator operator = new CalculatorWithOperator();

    @Test
    public void add() {

        assertEquals(mathCopy.add(1, 1), 2);
        assertEquals(mathExtends.add(1, 1), 2);
        assertEquals(operator.add(1, 1), 2);
    }

    @Test
    public void addWhitZeroArguments() {

        assertEquals(mathCopy.add(0, 0), 0);
        assertEquals(mathExtends.add(0, 0), 0);
        assertEquals(operator.add(0, 0), 0);
    }

    @Test
    public void addWhitNegativeArguments() {

        assertEquals(mathCopy.add(-1, -1), -2);
        assertEquals(mathExtends.add(-1, -1), -2);
        assertEquals(operator.add(-1, -1), -2);
    }

    @Test
    public void subtract() {

        assertEquals(mathCopy.subtract(1, 1), 0);
        assertEquals(mathExtends.subtract(1, 1), 0);
        assertEquals(operator.subtract(1, 1), 0);
    }

    @Test
    public void subtractZeroArguments() {

        assertEquals(mathCopy.subtract(0, 0), 0);
        assertEquals(mathExtends.subtract(0, 0), 0);
        assertEquals(operator.subtract(0, 0), 0);
    }

    @Test
    public void subtractNegativeArguments() {

        assertEquals(mathCopy.subtract(-1, -1), 0);
        assertEquals(mathExtends.subtract(-1, -1), 0);
        assertEquals(operator.subtract(-1, -1), 0);
    }

    @Test
    public void multiply() {

        assertEquals(mathCopy.multiply(1, 1), 1);
        assertEquals(mathExtends.multiply(1, 1), 1);
        assertEquals(operator.multiply(1, 1), 1);
    }

    @Test
    public void multiplyZeroArguments() {

        assertEquals(mathCopy.multiply(0, 0), 0);
        assertEquals(mathExtends.multiply(0, 0), 0);
        assertEquals(operator.multiply(0, 0), 0);
    }

    @Test
    public void multiplyNegativeArguments() {

        assertEquals(mathCopy.multiply(-1, -1), 1);
        assertEquals(mathExtends.multiply(-1, -1), 1);
        assertEquals(operator.multiply(-1, -1), 1);
    }

    @Test
    public void divide() {

        assertEquals(mathCopy.divide(1, 1), 1);
        assertEquals(mathExtends.divide(1, 1), 1);
        assertEquals(operator.divide(1, 1), 1);
    }

    @Test
    public void divideNegativeArguments() {

        assertEquals(mathCopy.divide(-1, -1), 1);
        assertEquals(mathExtends.divide(-1, -1), 1);
        assertEquals(operator.divide(-1, -1), 1);
    }

    @Test
    public void power() {

        assertEquals(mathCopy.exponent(2, 10), 1024);
        assertEquals(mathExtends.exponent(2, 10), 1024);
        assertEquals(operator.exponent(2, 10), 1024);
    }

    @Test
    public void powerZeroArguments() {

        assertEquals(mathCopy.exponent(0, 0), 1);
        assertEquals(mathExtends.exponent(0, 0), 1);
        assertEquals(operator.exponent(0, 0), 1);
    }

    @Test
    public void powerNegativeNumber() {

        assertEquals(mathCopy.exponent(-2, 10), 1024);
        assertEquals(mathExtends.exponent(-2, 10), 1024);
        assertEquals(operator.exponent(-2, 10), 1024);
    }

    @Test
    public void abs() {

        assertEquals(mathCopy.absolute(-2), 2);
        assertEquals(mathExtends.absolute(-2), 2);
        assertEquals(operator.absolute(-2), 2);
    }

    @Test
    public void sqrt() {

        assertEquals(mathCopy.square(4), 2);
        assertEquals(mathExtends.square(4), 2);
        assertEquals(operator.square(4), 2);
    }

    @Test
    public void sqrtWhitZeroArgument() {

        assertEquals(mathCopy.square(0), 0);
        assertEquals(mathExtends.square(0), 0);
        assertEquals(operator.square(0), 0);
    }

}