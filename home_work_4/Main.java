package home_work_4;

public class Main {
    public static void main(String[] args) {

        DataContainer<Integer> container = new DataContainer<>(Integer.class, 5);


        container.add(1);
        container.add(6);
        container.add(3);
        container.add(4);

        DataContainer.sort(container);
        System.out.println(container);

    }
}

