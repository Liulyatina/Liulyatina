package Test.home_work_2_test.cycleTest;

import home_work_2.cycle.MultiplyDigits;
import home_work_2.cycle.MultiplyNumbersWithRecursion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_1_1_test {
    @Test
    public void testCalculateFactorialWithLoop() {
        long result = MultiplyDigits.calculateFactorialWithLoop(5);
        assertEquals(120, result);
    }

    @Test
    public void testCalculateFactorialWithRecursion() {
        long result = MultiplyNumbersWithRecursion.calculateFactorialWithRecursion(5);
        assertEquals(120, result);
    }

    @Test
    public void testCalculateFactorialWithNegativeNumber() {
        long result = MultiplyDigits.calculateFactorialWithLoop(-5);
        assertEquals(-1, result);
    }
}
