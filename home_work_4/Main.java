package home_work_4;

public class Main {
    public static void main(String[] args) {

        DataContainer<String> container = new DataContainer<>(new String[1]);
        int index2 = container.add("Как дела");
        int index4 = container.add("Давай потом");
        int index3 = container.add("Работаю");
        int index1 = container.add("Привет");
        String text1 = container.get(index1);
        String text2 = container.get(index2);
        String text3 = container.get(index3);
        String text4 = container.get(index4);
        System.out.println(text1); //Привет
        System.out.println(text2); //Как дела
        System.out.println(text3); //Работаю
        System.out.println(text4); //Давай потом

        System.out.println(container.get(index1)); //Как дела
        container.sort(new StringLengthComparator()); //Сортируется по длинне
        System.out.println(container); // ["Работаю", "Как дела", "Давай потом"]
        container.sort(new StringAlphabeticComparator()); //Сортируется по алфавиту
        System.out.println(container); // ["Давай потом", "Как дела", "Работаю"]

    }
}

