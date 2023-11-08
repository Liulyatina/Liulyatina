package home_work_2.Cycle;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(exponentiation(3,2));
    }
    public static double exponentiation(double num, int exponent){
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
         result *= num;
        }
        System.out.println(num+" ^ "+exponent+" = "+result);
        return result;
    }
}
