package home_work_2.Arrays;

public class DoWhile implements IArraysOperation {
    @Override
    public void iterateAllElements(int[] array) {
        int i = 0;
        do {
            System.out.println(array[i] + " ");
            i++;
        } while (i < array.length);
        System.out.println();
    }

    @Override
    public void iterateSecondElement(int[] array) {
        int i = 1;
        do {
            System.out.println(array[i] + " ");
            i += 2;
        } while (i < array.length);
        System.out.println();
    }

    @Override
    public void iterateReverse(int[] array) {
        int i = array.length - 1;
        do {
            System.out.println(array[i] + " ");
            i--;
        } while (i >= 0);
        System.out.println();
    }
}
