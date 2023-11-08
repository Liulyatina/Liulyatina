package home_work_1_test;

import home_work_1.bitOperatiom.BitwiseOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task_1_Test {

    @Test
    @DisplayName("Результат оператора & : 12 | 13 = 1100")
    public void bitwiseOperationsAndTest() {
        Assertions.assertEquals(BitwiseOperation.bitwiseOperatorAnd(12, 13),"1100");
    }

    @Test
    @DisplayName("Результат оператора | : 12 | 13 = 1101")
    public void bitwiseOperationsOrTest() {
        Assertions.assertEquals(BitwiseOperation.bitwiseOperatorOr(12,13),"1101");
    }
}
