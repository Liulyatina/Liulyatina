package home_work_2.cycle;

public class LongOverflowExample {
    public static void main(String[] args) {
        System.out.println(multiplyUntilOverflow(1,3));
    }
        public static long multiplyUntilOverflow (long a, int multiplier){
            long result = a;
            long previousResult = a;
            boolean overflowOccurred = false;
            int iteration = 0;

            while (!overflowOccurred) {
                previousResult = result;
                result *= multiplier;

                if (result < previousResult) {
                    overflowOccurred = true;
                } else {
                    iteration++;
                }
            }

            System.out.println("Умножение на " + multiplier + ":");
            System.out.println("Значение до переполнения: " + previousResult);
            System.out.println("Значение после переполнения: " + result);
            System.out.println("Количество итераций: " + iteration);
            System.out.println();
            return result;
        }
    }

