package home_work_1.checker;

public class ByteConverter {
    public static void main(String[] args) {
        long bytes = 2048;

        double kilobytes = bytes / 1024.0;
        System.out.println(bytes + " байт(ов) = " + kilobytes + " килобайт(ов)");
    }
    public static double byteToKilobyte(double number) {

        return number / 1024;
    }

    public static double kilobyteToByte(double number) {

        return number * 1024;
    }
}