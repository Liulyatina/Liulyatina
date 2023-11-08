package home_work_1_test;

import home_work_1.checker.LeapYearChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_4_6_test {
    @Test
    @DisplayName("Определить високосный год или нет:2024 = true")
    public void isLeapYearTest_1() {
        Assertions.assertTrue(LeapYearChecker.isLeapYear(2024));
    }

    @Test
    @DisplayName("Определить високосный год или нет:2023= false")
    public void isLeapYearTest_2() {
        Assertions.assertFalse(LeapYearChecker.isLeapYear(2023));
    }

    @Test
    @DisplayName("Определить високосный год или нет:-2024= false")
    public void isLeapYearTest_3() {
        Assertions.assertFalse(LeapYearChecker.isLeapYear(-2024));
    }

    @Test
    @DisplayName("Определить високосный год или нет:0 = false")
    public void isLeapYearTest_4() {
        Assertions.assertFalse(LeapYearChecker.isLeapYear(0));
    }
}
