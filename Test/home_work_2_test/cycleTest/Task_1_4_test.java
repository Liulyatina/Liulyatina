package home_work_2_test.cycleTest;

import home_work_2.cycle.LongOverflowExample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task_1_4_test {
    @Test
    public void testMultiplyUntilOverflowWith3() {
        long result = LongOverflowExample.multiplyUntilOverflow(1L, 3);
        assertTrue(result < 0);
    }

    @Test
    public void testMultiplyUntilOverflowWith188() {
        long result = LongOverflowExample.multiplyUntilOverflow(1L, 188);
        assertTrue(result < 0);
    }

    @Test
    public void testMultiplyUntilOverflowWithNegative19() {
        long result = LongOverflowExample.multiplyUntilOverflow(1L, -19);
        assertTrue(result < 0);
    }

}
