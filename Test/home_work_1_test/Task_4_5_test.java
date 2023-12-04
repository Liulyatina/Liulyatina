package Test.home_work_1_test;

import home_work_1.checker.CharacterTypeChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_4_5_test {
    @Test
    @DisplayName("4.5 Буква или иной символ E = true")
    public void letterOrSymbolTest_1(){
        Assertions.assertEquals(CharacterTypeChecker.letterOrSymbol('E'),"Вы ввели букву: E");
    }


    @Test
    @DisplayName("4.5 Буква или иной символ # = true")
    public void letterOrSymbolTest_2() {
        Assertions.assertEquals(CharacterTypeChecker.letterOrSymbol('#'), "Вы ввели символ: #");
    }
}
