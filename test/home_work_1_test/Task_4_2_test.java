package test.home_work_1_test;

import home_work_1.checker.AverageCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_4_2_test {
    @Test
    @DisplayName("Среди трёх чисел найти среднее: 10,33,1 = 10")
    public void middleOfThreeDigit_1(){
        Assertions.assertEquals(AverageCalculator.middleOfThreeDigit(10,33,1),10);
    }
    @Test
    @DisplayName("Среди трёх чисел найти среднее: -10,33,1 = 1")
    public void middleOfThreeDigit_2(){
        Assertions.assertEquals(AverageCalculator.middleOfThreeDigit(-10,33,1),1);
    }
    @Test
    @DisplayName("Среди трёх чисел найти среднее: 0,0,0 = 0")
    public void middleOfThreeDigit_3(){
        Assertions.assertEquals(AverageCalculator.middleOfThreeDigit(0,0,0),0);
    }
    @Test
    @DisplayName("Среди трёх чисел найти среднее: 0,1,0 = 0")
    public void middleOfThreeDigit_4(){
        Assertions.assertEquals(AverageCalculator.middleOfThreeDigit(0,1,0),0);
    }
    @Test
    @DisplayName("Среди трёх чисел найти среднее: -10,-33,18 = 18")
    public void middleOfThreeDigit_5(){
        Assertions.assertEquals(AverageCalculator.middleOfThreeDigit(-10,-33,18),-10);
    }
}
