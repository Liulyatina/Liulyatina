package test.home_work_2_test.arraysTest;

import home_work_2.arrays.SortsUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task_4_2_test {
    @Test
    public void bubbleSortEmptyArrayTest() {

        int[] arr = {};

        SortsUtils.sort(arr);

        int[] resultArray = {};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void bubbleSortArrayWithOneElementTest() {

        int[] arr = {1};

        SortsUtils.sort(arr);

        int[] resultArray = {1};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void bubbleSortArrayWithTwoElementsTest() {

        int[] arr = {2, 1};

        SortsUtils.sort(arr);

        int[] resultArray = {1, 2};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void bubbleSortArrayWithMultipleElementsTest() {

        int[] arr = {5, 3, 2, 1, 4};

        SortsUtils.sort(arr);

        int[] resultArray = {1, 2, 3, 4, 5};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void bubbleSortArrayWithNegativeMultipleElementsTest() {

        int[] arr = {-5, -3, -2, -1, -4};

        SortsUtils.sort(arr);

        int[] resultArray = {-5, -4, -3, -2, -1};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void shakeSortEmptyArrayTest() {

        int[] arr = {};

        SortsUtils.shake(arr);

        int[] resultArray = {};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void shakeSortArrayWithOneElementTest() {

        int[] arr = {1};

        SortsUtils.shake(arr);

        int[] resultArray = {1};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void shakeSortArrayWithTwoElementsTest() {

        int[] arr = {2, 1};

        SortsUtils.shake(arr);

        int[] resultArray = {1, 2};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void shakeSortArrayWithMultipleElementsTest() {

        int[] arr = {5, 3, 2, 1, 4};

        SortsUtils.shake(arr);

        int[] resultArray = {1, 2, 3, 4, 5};

        assertArrayEquals(arr, resultArray);
    }

    @Test
    public void shakeSortArrayWithNegativeMultipleElementsTest() {

        int[] arr = {-3, -5, -2, -1, -4};

        SortsUtils.shake(arr);

        int[] resultArray = {-5, -4, -3, -2, -1};

        assertArrayEquals(arr, resultArray);
    }
}
