package home_work_1_test;

import home_work_1.SleepIn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_5_test {
    @Test
    @DisplayName("Спать или идти на работу:рабочий день - нет,отпуск - нет = Можно спать дальше!")
    public void sleepInTest_1() {

        boolean weekday = false;
        boolean vocation = false;

        Assertions.assertTrue(SleepIn.sleepIn(weekday, vocation));

    }

    @Test
    @DisplayName("Спать или идти на работу:рабочий день - да,отпуск - нет = Пора идти на работу")
    public void sleepInTest_2() {

        boolean weekday = true;
        boolean vocation = false;

        Assertions.assertFalse(SleepIn.sleepIn(weekday, vocation));

    }

    @Test
    @DisplayName("Спать или идти на работу:рабочий день - да,отпуск - да = Можно спать дальше!")
    public void sleepInTest_3() {

        boolean weekday = true;
        boolean vocation = true;

        Assertions.assertTrue(SleepIn.sleepIn(weekday, vocation));

    }

    @Test
    @DisplayName("Вывод сообщения: рабочий день - да ,отпуск - нет = Пора идти на работу!")
    public void printAnswerTest_1() {

        boolean weekday = true;
        boolean vocation = false;

        Assertions.assertEquals(SleepIn.printAnswer(weekday, vocation), "Пора идти на работу!");

    }

    @Test
    @DisplayName("Вывод сообщения: рабочий день - да ,отпуск - да = Можно спать дальше!")
    public void printAnswerTest_2() {

        boolean weekday = true;
        boolean vocation = true;

        Assertions.assertEquals(SleepIn.printAnswer(weekday, vocation), "Можно спать дальше!");

    }
}
