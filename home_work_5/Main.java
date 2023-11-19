package home_work_5;


import home_work_5.Animal.Animal;
import home_work_5.Animal.AnimalComparator;
import home_work_5.Animal.AnimalNick.FileRandomAnimalNick;
import home_work_5.Animal.AnimalNick.RandomAnimalNick;
import home_work_5.Animal.AnimalNick.RandomRussianStringForAnimalNick;
import home_work_5.Animal.AnimalNick.RandomStringGenerationAnimalForAnimalNick;
import home_work_5.Person.Name.FileRandomName;
import home_work_5.Person.Name.RandomName;
import home_work_5.Person.Name.RandomRussianString;
import home_work_5.Person.Name.RandomStringGeneration;
import home_work_5.Person.Person;
import home_work_5.Person.PersonComparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> names = Arrays.asList("Roman", "Ilya", "Serghei", "Artur", "Tatiana", "Angelica");
        List<String> nicks = Arrays.asList("Badi", "Charlie", "Bear", "Shit", "Max", "Doni");
        List<String> personNicks = Arrays.asList("Liulyatina", "Simple", "Sweet", "Cj", "Killer", "Po");

        try {
            String currentDirectory = System.getProperty("user.dir");

            // Перед записью в файл, проверим существование файла и создадим его, если он не существует
            createFileIfNotExists(currentDirectory, "Task_Name.txt");
            createFileIfNotExists(currentDirectory, "Task_Nick.txt");
            createFileIfNotExists(currentDirectory, "Task_PersonNick.txt");

            Path filePath = Paths.get(currentDirectory, "Task_Name.txt");
            Files.write(filePath, names);
            System.out.println("Файл создан: " + filePath.toAbsolutePath());

            Path filePath2 = Paths.get(currentDirectory, "Task_Nick.txt");
            Files.write(filePath2, nicks);
            System.out.println("Файл создан: " + filePath2.toAbsolutePath());

            Path filePath3 = Paths.get(currentDirectory, "Task_PersonNick.txt");
            Files.write(filePath3, personNicks);
            System.out.println("Файл создан: " + filePath3.toAbsolutePath());


        } catch (IOException e) {
            e.printStackTrace();
        }

        // Генерация случайной строки длиной 10 символов
        String randomString = RandomStringGeneration.radomGenerationString(10);
        String randomRussianString = RandomRussianString.radomRussianRenerationString(10);
        String randomName = RandomName.randomName();
        String randomFileName = FileRandomName.generateRandomFileName();

        String randomString1 = RandomStringGenerationAnimalForAnimalNick.radomGenerationString(10);
        String randomRussianStringForNick = RandomRussianStringForAnimalNick.radomRussianRenerationString(10);
        String randomNick = RandomAnimalNick.randomNick();
        String randomFileNick = FileRandomAnimalNick.generateRandomFileNick();

        // Вывод сгенерированной строки
        System.out.println("Случайная строка: " + randomString);
        System.out.println("Случайная строка: " + randomRussianString);
        System.out.println("Случайная строка: " + randomName);
        System.out.println("Случайная строка: " + randomFileName);

        System.out.println();

        System.out.println("Случайная строка: " + randomString1);
        System.out.println("Случайная строка: " + randomRussianStringForNick);
        System.out.println("Случайная строка: " + randomNick);
        System.out.println("Случайная строка: " + randomFileNick);

        System.out.println();

        List<Person> people = new ArrayList<>();

        people.add(new Person("liulyatina", "password12", "Roman"));
        people.add(new Person("Simple", "password1", "Ilya"));
        people.add(new Person("Sweet", "password", "Artur"));

        Collections.sort(people, new PersonComparator.LengthPasswordComparator());
        System.out.println("Сортировка по длине пароля " + people);

        Collections.sort(people, new PersonComparator.LengthPasswordAndNickComparator());
        System.out.println("Сортировка по длине пароля и по псевдониму " + people);

        BubbleSort.customBubbleSort(people, new PersonComparator.LengthPasswordAndNickComparator());
        System.out.println("Сортировка пузырьком по длине пароля и по псевдониму " + people);

        List<Animal> animal = new ArrayList<>();

        animal.add(new Animal(5, "Badi"));
        animal.add(new Animal(3, "Charlie"));
        animal.add(new Animal(6, "Bear"));

        Collections.sort(animal, new AnimalComparator.ageCopmarator());
        System.out.println("Сортировка по возрасту " + animal);

        Collections.sort(animal, new AnimalComparator.agedAndNickCompatator());
        System.out.println("Сортировка по возрасту и по псевдониму " + animal);

        BubbleSort.customBubbleSort(animal, new AnimalComparator.agedAndNickCompatator());
        System.out.println("Сортировка пузырьком по возрасту и по псевдониму " + people);
    }

    private static void createFileIfNotExists(String directory, String fileName) throws IOException {
        Path filePath = Paths.get(directory, fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }
}