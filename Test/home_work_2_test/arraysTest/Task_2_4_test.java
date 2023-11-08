package home_work_2_test.arraysTest;

import home_work_2.Arrays.ArraysTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task_2_4_test {
    @Test
    public void sumOfEvenElementsOfArray() {

        Assertions.assertEquals(ArraysTasks.sumOfEvenElements(new int[]{1, 2, 3, 10}), 12);
    }

    @Test
    public void sumOfEvenElementsOfArrayWhitNegativeNumbers() {

        Assertions.assertEquals(ArraysTasks.sumOfEvenElements(new int[]{-1, -2, -3, -10}), 0);
    }

    @Test
    public void maxElementOfArrayForEvenIndex() {

        Assertions.assertEquals(ArraysTasks.maxOfEvenElements(new int[]{1, 2, 13, 10, 12}), 13);
    }

    @Test
    public void maxElementOfArrayForEvenIndexWhitNegativeNumbers() {

        Assertions.assertEquals(ArraysTasks.maxOfEvenElements(new int[]{-1, -2, -13, -10, -12}), 0);
    }
    @Test
    public void twoMinElementsOfArray() {

        Assertions.assertArrayEquals(ArraysTasks.findTwoSmallestElement(new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, -10, 11}), new int[]{0, -10});
    }
    @Test
    public void sumOfArrayDigit() {

        Assertions.assertEquals(ArraysTasks.sumOfDigitsInArray(new int[]{55, 5}),15);
    }
}
