package home_work_5;

import home_work_5.Animal.Animal;
import home_work_5.Person.Name.RandomStringGeneration;
import home_work_5.Person.Person;

import java.util.*;

public class CollectionActions {
    public static <T> void performOperations(Collection<T> collection, String collectionType) {
        System.out.println("Операции с коллекцией " + collectionType);
        System.out.println("Количество элементов в коллекции: " + collection.size());

        // 6.4.1. Заполнение коллекции
        performAddAllOperation(collection, collectionType);

        // 6.4.2. Итерирование коллекции
        performIterationOperation(collection, collectionType, true); // Итератор
        performIterationOperation(collection, collectionType, false); // Другой способ (не foreach)

        // 6.4.3. Удаление всех элементов коллекции
        performRemoveAllOperation(collection, collectionType, true); // Итератор
        performRemoveAllOperation(collection, collectionType, false); // Другой способ

        System.out.println(); // Разделитель между коллекциями
    }
    public static <T> Collection<T> generateRandomData(Class<T> clazz, int dataSize) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            result.add(generateEntity(clazz));
        }
        return result;
    }

    public static <T> T generateEntity(Class<T> clazz) {
        if (clazz.equals(Person.class)) {
            return (T) generateRandomPerson();
        } else if (clazz.equals(Animal.class)) {
            return (T) generateRandomAnimal();
        }
        return null;
    }

    private static Person generateRandomPerson() {
        Random random = new Random();
        String nick = RandomStringGeneration.radomGenerationString(8);
        String password = RandomStringGeneration.radomGenerationString(8);
        String name = RandomStringGeneration.radomGenerationString(10);
        return new Person(nick, password, name);
    }

    private static Animal generateRandomAnimal() {
        Random random = new Random();
        int age = random.nextInt(15) + 1;
        String nick = RandomStringGeneration.radomGenerationString(8);
        return new Animal(age, nick);
    }

    public static <T> void performAddAllOperation(Collection<T> collection, String collectionType) {
        long startTime = System.currentTimeMillis();
        Collection<T> newData = generateRandomData((Class<T>) collection.iterator().next().getClass(), 1_000_000);

        if (collectionType.equals("LinkedList") || collectionType.equals("ArrayList")) {
            List<T> list = (List<T>) collection;
            list.addAll(newData);
        } else if (collectionType.equals("HashSet") || collectionType.equals("TreeSet")) {
            collection.addAll(newData);
        }

        long endTime = System.currentTimeMillis();
        printElapsedTime("Операция: Заполнение коллекции", startTime, endTime);
    }
    public static <T> void performIterationOperation(Collection<T> collection, String collectionType, boolean useIterator) {
        long startTime = System.currentTimeMillis();
        if (useIterator) {
            Iterator<T> iterator = collection.iterator();
            while (iterator.hasNext()) {
                T element = iterator.next();
            }
        } else {
            for (T element : collection) {
            }
        }
        long endTime = System.currentTimeMillis();
        printElapsedTime("Операция: Итерирование коллекции" + (useIterator ? " (iterator)" : " (не foreach)"), startTime, endTime);
    }

    public static <T> void performRemoveAllOperation(Collection<T> collection, String collectionType, boolean useIterator) {
        long startTime = System.currentTimeMillis();
        if (useIterator) {
            Iterator<T> iterator = collection.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        } else {
            collection.clear();
        }
        long endTime = System.currentTimeMillis();
        printElapsedTime("Операция: Удаление всех элементов коллекции" + (useIterator ? " (iterator)" : " (другой способ)"), startTime, endTime);
    }

    public static void printElapsedTime(String operation, long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        System.out.println(operation + ". Заняла " + elapsedTime + " мс");
    }

}


