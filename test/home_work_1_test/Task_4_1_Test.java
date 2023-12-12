package test.home_work_1_test;

import home_work_1.checker.OddNumberChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task_4_1_Test {
    @Test
    @DisplayName("Определеть нечётное число 0 = false")
    public void isOddNumber_1(){
        OddNumberChecker oddNumberChecker = new OddNumberChecker();
        assertFalse(oddNumberChecker.isOddNumberchecker(0));
    }
    @Test
    @DisplayName("Определеть нечётное число 2 = false")
    public void isOddNumber_2(){
        OddNumberChecker oddNumberChecker = new OddNumberChecker();
        assertFalse(oddNumberChecker.isOddNumberchecker(2));
    }
    @Test
    @DisplayName("Определеть нечётное число -2 = false")
    public void isOddNumber_3(){
        OddNumberChecker oddNumberChecker = new OddNumberChecker();
        assertFalse(oddNumberChecker.isOddNumberchecker(-2));
    }
    @Test
    @DisplayName("Определеть нечётное число 3 = true")
    public void isOddNumber_4(){
        OddNumberChecker oddNumberChecker = new OddNumberChecker();
        assertTrue(oddNumberChecker.isOddNumberchecker(3));
    }
    @Test
    @DisplayName("Определеть нечётное число -3 = true")
    public void isOddNumber_5(){
        OddNumberChecker oddNumberChecker = new OddNumberChecker();
        assertTrue(oddNumberChecker.isOddNumberchecker(-3));
    }
}
