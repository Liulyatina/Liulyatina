package test.home_work_1_test;

import home_work_1.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_7_test {
    @Test
    @DisplayName("Конвертирует массив из 10 цифр в строку формата : (XXX) XXX-XXXX")
    public void createPhoneNumberTest_1() {

        int[] phoneNumberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        Assertions.assertEquals(PhoneNumber.createPhoneNumber(phoneNumberArray), "(123) 456-7890");

    }

    @Test
    @DisplayName("Конвертирует массив из 11 цифр в строку формата : null")
    public void createPhoneNumberTest_2() {

        int[] phoneNumberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11};

        Assertions.assertNull(PhoneNumber.createPhoneNumber(phoneNumberArray));

    }
}
