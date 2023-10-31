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
        if (index >= 0 && index < size) {
            // Сдвигаем элементы справа от индекса на одну позицию влево
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null; // Удаляем последний элемент
            size--;
            return true;
        }
        return false; // Возвращаем false, если индекс недопустим
    }

    public boolean delete(T item) {
        if (item == null) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[size - 1] = null;
                size--;
                return true;
            }
        }

        return false;
    }


    public int add(T item) {
        if (item == null) {
            return -1; // Вставка null не допускается
        }
        if (size < data.length) {
            for (int i = size - 1; i >= 0; i--) {
                if (data[i] != null) {
                    data[i + 1] = item;
                    size++;
                    return i + 1;
                }
            }
        } else {
            data = Arrays.copyOf(data, data.length * 2);
            data[size] = item;
            size++;
            return size - 1;
        }
        data[0] = item;
        size++;
        return 0;
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
        if (index >= 0 && index < size()) {
            return data[index];
        }
        return null;
    }

    public T[] getItems() {
        return Arrays.copyOf(data, size);
    }

    public int size() {
        return size;
    }


    public String toString() {
        StringBuilder result = new StringBuilder("[");
        boolean firstElement = true; // Флаг для отслеживания первого элемента

        for (int i = 0; i < size; i++) {
            if (data[i] != null) {
                if (!firstElement) {
                    result.append(", ");
                }
                result.append(data[i].toString());
                firstElement = false;
            }
        }

        result.append("]");
        return result.toString();
    }

    private static class ComparableComaparator implements Comparator<Comparable> {
        @Override
        public int compare(Comparable o1, Comparable o2) {
            return o1.compareTo(o2);
        }
    }
}