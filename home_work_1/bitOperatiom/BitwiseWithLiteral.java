package home_work_1.bitOperatiom;

public class BitwiseWithLiteral {
    public static void main(String[] args) {
        // Попробуем выполнить побитовую операцию И с литералом 42.5
        int result = (int) 42.5 & 42;
        // Литерал 42.5 будет автоматически округлен до 42 (целого числа)
        // Затем будет выполнена побитовая операция И (&) с числом 42
        // Результатом будет число 42 & 42, что равно 42 (в двоичной системе: 00101010)
        System.out.println("Результат операции И с литералом 42.5: " + result);
    }
}