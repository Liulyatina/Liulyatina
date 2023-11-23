package home_work_2_test.cycleTest;

import home_work_2.cycle.Quests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_1_5_test {
    @Test
    public void testFindLargestDigit() {
        int largest = Quests.findLargestDigit(12345);
        assertEquals(5, largest);
    }

    @Test
    public void testEvenProbability() {
        double probability = Quests.evenProbability(10);
        assertEquals(0.5, probability, 0.01); // Предполагаемая вероятность четных чисел
    }

    @Test
    public void testEvenAndOddDigit() {
        Quests.evenAndOddDigit(12345);
        // Добавьте утверждения для проверки вывода
    }

    @Test
    public void testPrintFibonacci() {
        // Вызовите метод и добавьте утверждения для проверки вывода
    }

    @Test
    public void testPrintSeriesWithStep() {
        // Вызовите метод и добавьте утверждения для проверки вывода
    }

    @Test
    public void testReverseNumber() {
        long reversed = Quests.reverseNumber(12345);
        assertEquals(54321, reversed);
    }
}

