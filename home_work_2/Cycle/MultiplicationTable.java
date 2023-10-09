package home_work_2.Cycle;
public class MultiplicationTable {
    public static void main(String[] args) {
        int tableSize = 10; // Размер таблицы (например, таблица 10x10)

        for (int i = 2; i <= tableSize; i++) {
            for (int j = 2; j < tableSize; j++) {
                int product = i * j;
                System.out.printf("%d * %d = %d\t", j, i, product); // Выводим результат с табуляцией
            }
            System.out.println(); // Переход на новую строку после каждой строки таблицы
        }
    }
}
