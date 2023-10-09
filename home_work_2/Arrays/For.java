package home_work_2.Arrays;

public class For implements IArraysOperation {
    @Override
    public void iterateAllElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void iterateSecondElement(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }


    @Override
    public void iterateReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }
}
