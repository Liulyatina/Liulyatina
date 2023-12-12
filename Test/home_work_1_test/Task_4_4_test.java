package Test.home_work_1_test;

import home_work_1.checker.ByteConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_4_4_test {
    @Test
    @DisplayName("Перевести байты в килобайты")
    public void byteToKilobyteTest_1() {

        Assertions.assertEquals(ByteConverter.byteToKilobyte(1024), 1);

    }

    @Test
    @DisplayName("4.4 Перевести килобайты в байты")
    public void kilobyteToByteTest_1() {

        Assertions.assertEquals(ByteConverter.kilobyteToByte(1), 1024);

    }

}
