package home_work_4;

import java.util.*;

import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

public class DataContainer<T> {
    public T[] data;
    private int size;

    public DataContainer(T[] initialData) {
        this.data = Arrays.copyOf(initialData, initialData.length);
    }

    public int add(T item) {
        if (item == null) {
            return -1;
        }

        if (size >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        data[size] = item;
        size++;

        return size - 1;
    }

    public T get(int index) {
        if (index >= 0 && index < size()) {
            System.out.println("Error");
        }
        return data[index]; // You can choose how to handle invalid index
    }
    public T[] getItems(){
        return Arrays.copyOf(data, size);
    }
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
    public static void main(String[] args) {

        DataContainer<String> container = new DataContainer<>();
        int index1 = container.add("Привет");
        int index2 = container.add("Как дела");
        int index3 = container.add("Работаю");
        int index4 = container.add("Давай потом");
        String text1 = container.get(index1);
        String text2 = container.get(index2);
        String text3 = container.get(index3);
        String text4 = container.get(index4);

        System.out.println(text1); // Привет
        System.out.println(text2); // Как дела
        System.out.println(text3); // Работаю
        System.out.println(text4); // Давай потом

        container.delete(text1);
        System.out.println(container.get(index1)); // Как дела

        container.sort(new StringLengthComparator()); // Сортируется по длине
        System.out.println(container); // ["Привет", "Работаю", "Как дела", "Давай потом"]

        container.sort(new StringAlphabeticComparator()); // Сортируется по алфавиту
        System.out.println(container); // ["Давай потом", "Как дела", "Привет", "Работаю"]

    }
}
