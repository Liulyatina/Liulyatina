package Home_work_1.Checker;

public class ByteConverter {
    public static void main(String[] args) {
        long bytes = 2048; // Замените на количество байт

        double kilobytes = bytes / 1024.0;
        System.out.println(bytes + " байт(ов) = " + kilobytes + " килобайт(ов)");
    }
}