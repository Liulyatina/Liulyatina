package home_work_2.Arrays;

public class ForEach implements IArraysOperation {
    @Override
    public void iterateAllElements(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Override
    public void iterateSecondElement(int[] array) {
        boolean print = false;
        for (int num : array) {
            if (print) {
                System.out.print(num + " ");
            }
            print = !print;
        }
        System.out.println();
    }

    @Override
    public void iterateReverse(int[] array) {
        int[] reversedArray = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[index++] = array[i];
        }
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}