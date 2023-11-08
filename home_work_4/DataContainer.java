package home_work_4;

import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T extends Comparable<T>> {
    public T[] data;
    int size;

    public DataContainer(T[] initArr) {
        this.data = initArr;

    }

    public boolean delete(int index) {
        if (index < data.length && index > -1) {
            for (int i = index; i < data.length - 1; i++) {
                T temp = data[i];
                data[i] = data[i + 1];
                data[i + 1] = temp;
            }
            data = Arrays.copyOf(data, data.length - 1);
            return true;
        }
        return false;
    }

    public boolean delete(T item) {
        if (item == null) {
            return false;
        }
        int i = 0;
        while (i < data.length) {
            if (item.equals(data[i])) {
                return delete(i);
            }
            i++;
        }
        return false;
    }


    public int add(T item) {
        if (item != null) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    data[i] = item;
                    return i;
                }
            }
            data = Arrays.copyOf(data, data.length + 1);
            data[data.length - 1] = item;
            return data.length - 1;
        } else {
            return -1;
        }
    }

    private int findEmptyIndex() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                return i;
            }
        }
        return size;
    }

    public void sort(Comparator<T> cmp) {
        T[] arr = data;

        T temp;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < arr.length; i++) {
                if (cmp.compare(arr[i], arr[i - 1]) < 0) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void sort(DataContainer<T> container){
        sort(container, new ComparableComaparator());
    }

    public static <T extends Comparable<T>> void sort(DataContainer<T> container, Comparator<? super T> cmp){
        T[] arr = container.data;

        T temp;
        boolean isSorted = false;

        while (!isSorted) {

            isSorted = true;

            for (int i = 1; i < arr.length; i++) {
                if (cmp.compare(arr[i], arr[i -1]) < 0) {

                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    isSorted = false;
                }
            }
        }
    }


    public T get(int index) {
        if (index < 0 || index > data.length - 1) {
            return null;
        }
        return data[index];
    }

    public T[] getItems() {
        return data;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[");
        boolean comma = false;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (comma) {
                    strBuilder.append(", ");
                }
                strBuilder.append(data[i]);
                comma = true;
            }
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }

    private static class ComparableComaparator implements Comparator<Comparable> {
        @Override
        public int compare(Comparable o1, Comparable o2) {
            return o1.compareTo(o2);
        }
    }
}