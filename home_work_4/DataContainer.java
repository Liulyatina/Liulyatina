package home_work_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T extends Comparable<T>> {
    public T[] data;
    int size;

    public DataContainer(Class<T> clazz, int initialCapacity) {
        data = (T[]) Array.newInstance(clazz, initialCapacity);
        size = 0;
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

     public void sort(Comparator<T> comparator) {
        Arrays.sort(data, 0, size, comparator);
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
    public static <E extends Comparable<E>> void sort(DataContainer<E> container) {
        E[] data = container.data;  // Получаем массив данных из контейнера
        Arrays.sort(data, 0, container.size, null);
    }

    public static <E extends Comparable<E>> void sort(DataContainer<E> container, Comparator<? super E> comparator) {
        E[] data = container.data;  // Получаем массив данных из контейнера
        Arrays.sort(data, 0, container.size, comparator);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.append(", ");
            }
            if (data[i] != null) {
                result.append(data[i].toString());
            }
        }
        result.append("]");
        return result.toString();
    }
}