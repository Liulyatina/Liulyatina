package home_work_2_test.cycleTest;

import home_work_2.Cycle.NumberMultiplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_1_2_test {
    @Test
    public void testMultiplyDigitsInNumber() {
        int result = NumberMultiplier.multiplyDigitsInNumber("181232375");
        assertEquals(10_080, result);
    }

    @Test
    public void testMultiplyDigitsInNegativeNumber() {
        int result = NumberMultiplier.multiplyDigitsInNumber("-123");
        assertEquals(-1, result);
    }

    @Test
    public void testMultiplyDigitsInNonIntegerNumber() {
        int result = NumberMultiplier.multiplyDigitsInNumber("99.2");
        assertEquals(-1, result);
    }

    @Test
    public void testMultiplyDigitsInNonNumberInput() {
        int result = NumberMultiplier.multiplyDigitsInNumber("Привет");
        assertEquals(-1, result);
    }
}
