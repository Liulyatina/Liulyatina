package Test.home_work_2_test.cycleTest;

import home_work_2.cycle.Exponentiation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_1_3_test {
    @Test
    @DisplayName("Возведение в степень")
    public void exponentiation() {
        Assertions.assertEquals(Exponentiation.exponentiation(2, 2), 4);
    }

    @Test
    @DisplayName("Возведение в степень 0")
    public void exponentiation_1() {
        Assertions.assertEquals(Exponentiation.exponentiation(2, 0), 1);
    }

    @Test
    @DisplayName("Возведение в  отрицательную степень")
    public void exponentiation_2() {
        Assertions.assertEquals(Exponentiation.exponentiation(2, -2), 1);
    }
}
