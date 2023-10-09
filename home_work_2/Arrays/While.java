package home_work_2.Arrays;

public class While implements IArraysOperation {
    @Override
    public void iterateAllElements(int[] array) {
        int i = 0;
        while (i < array.length) {
            System.out.println(array[i] + " ");
            i++;
        }
        System.out.println();
    }

    @Override
    public void iterateSecondElement(int[] array) {
        int i = 1;
        while (i < array.length) {
            System.out.println(array[i]+" ");
            i += 2;
        }
        System.out.println();
    }

    @Override
    public void iterateReverse(int[] array) {
        int i = array.length - 1;
        while (i>=0){
            System.out.println(array[i]+" ");
            i--;
        }
        System.out.println();
    }
}
