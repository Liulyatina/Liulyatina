package home_work_2.Cycle;

public class LongOverflowExample {
    public static void main(String[] args) {
        long a = 1;

        // Множители
        long[] multipliers = {3, 188, -19, 2, 7}; // Добавьте любые другие множители, которые вы хотите проверить

        for (long multiplier : multipliers) {
            System.out.println("Умножение на " + multiplier + ":");

            long resultBeforeOverflow = a;
            long resultAfterOverflow = a;

            boolean overflowOccurred = false;

            while (!overflowOccurred) {
                resultBeforeOverflow = resultAfterOverflow;
                resultAfterOverflow = resultAfterOverflow * multiplier;

                // Проверяем, произошло ли переполнение
                if (resultBeforeOverflow > resultAfterOverflow) {
                    overflowOccurred = true;
                } else {
                    System.out.println(resultAfterOverflow);
                }
            }

            System.out.println("Значение до переполнения: " + resultBeforeOverflow);
            System.out.println("Значение после переполнения: " + resultAfterOverflow);
            System.out.println();
        }
    }
}

