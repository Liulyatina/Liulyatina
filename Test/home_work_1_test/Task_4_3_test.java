package home_work_1_test;

import home_work_1.checker.DivisibilityChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Task_4_3_test {
    @Test
    @DisplayName("Проверка делимости одного числа на другое 2/2 = true")
    public void divisionChek_1() {
        Assertions.assertTrue(DivisibilityChecker.divisionCheck(2, 2));
    }

    @Test
    @DisplayName("Проверка делимости одного числа на другое 5/2 = false")
    public void divisionChek_2() {
        Assertions.assertFalse(DivisibilityChecker.divisionCheck(5, 2));
    }
    @Test
    @DisplayName("Проверка делимости одного числа на другое -2/-2 = true")
    public void divisionChek_3() {
        Assertions.assertTrue(DivisibilityChecker.divisionCheck(-2, -2));
    }

    @Test
    @DisplayName("Проверка делимости одного числа на другое 2/0 = false")
    public void divisionChek_4() {
        try {
            boolean result = DivisibilityChecker.divisionCheck(10, 0);
            fail("Expected IllegalArgumentException, but got result: " + result);
        } catch (IllegalArgumentException e) {
            assertEquals("Divider cannot be 0", e.getMessage());
        }
    }
}
