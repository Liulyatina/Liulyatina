package Test.home_work_1_test;

import home_work_1.name.NameIfElse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_6_test {
    @Test
    @DisplayName("Приветствие Васи = Привет! Я тебя так долго ждал")
    public void senTest_1() {

        Assertions.assertEquals(NameIfElse.sen("Вася"), "Привет!\nЯ тебя так долго ждал");

    }

    @Test
    @DisplayName("Приветствие Анастасии = Я тебя так долго ждал")
    public void senTest_2() {

        Assertions.assertEquals(NameIfElse.sen("Анастасия"), "Я тебя так долго ждал");

    }

    @Test
    @DisplayName("Приветствие другое имя = Добрый день, а вы кто?")
    public void senTest_3() {

        Assertions.assertEquals(NameIfElse.sen("другое имя"), "Добрый день, а вы кто?");

    }
}
