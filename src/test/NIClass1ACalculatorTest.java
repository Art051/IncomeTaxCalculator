package test;

import com.company.NIClass1ACalculator;
import com.company.PAYECalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NIClass1ACalculatorTest {

    @Test
    void testExemptionFromNI() {
        // given
        float grossPay = 5_000;
        NIClass1ACalculator niClass1ACalculator = new NIClass1ACalculator(grossPay);

        // when
        float result = niClass1ACalculator.calculateNI(grossPay);

        // then
        float expected = 0;
        assertEquals(expected, result);
    }
    @Test
    void testPay12Percent() {
        // given
        float grossPay = 30_000;
        NIClass1ACalculator niClass1ACalculator = new NIClass1ACalculator(grossPay);

        // when
        float result = niClass1ACalculator.calculateNI(grossPay);

        // then
        float expected = 2_452.3198F;
        assertEquals(expected, result);
    }

    @Test
    void testPay12And2Percent() {
        // given
        float grossPay = 101_140;
        NIClass1ACalculator niClass1ACalculator = new NIClass1ACalculator(grossPay);

        // when
        float result = niClass1ACalculator.calculateNI(grossPay);

        // then
        float expected = 5_901.92F;
        assertEquals(expected, result);
    }
}