package test;

import com.company.PAYECalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PAYECalculatorTest {

    @Test
    void testNoReductionOfAllowanceBelowBasicBand() {
        // given
        float grossPay = 5_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculateAdjustedPersAllowance(grossPay);

        // then
        float expected = 12_570;
        assertEquals(expected, result);
    }

    @Test
    void testNoReductionOfAllowanceInBasicBand() {
        // given
        float grossPay = 30_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculateAdjustedPersAllowance(grossPay);

        // then
        float expected = 12_570;
        assertEquals(expected, result);
    }

    @Test
    void testReduceAllowanceToTwelveThousand() {
        // given
        float grossPay = 101_140;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculateAdjustedPersAllowance(grossPay);

        // then
        float expected = 12_000;
        assertEquals(expected, result);
    }

    @Test
    void testReduceAllowanceToZero() {
        // given
        float grossPay = 125_140;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculateAdjustedPersAllowance(grossPay);

        // then
        float expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void testStopReductionAtZero() {
        // given
        float grossPay = 200_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculateAdjustedPersAllowance(grossPay);

        // then
        float expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void testNoPAYE() {
        // given
        float grossPay = 5_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculatePAYE(grossPay);

        // then
        float expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void testPAYEBasicBand() {
        // given
        float grossPay = 30_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculatePAYE(grossPay);

        // then
        float expected = 3_486;
        assertEquals(expected, result);
    }

    @Test
    void testPAYEHigherBand() {
        // given
        float grossPay = 80_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculatePAYE(grossPay);

        // then
        float expected = 19_432;
        assertEquals(expected, result);
    }

    @Test
    void testAdditionalBand() {
        // given
        float grossPay = 200_000;
        PAYECalculator payeCalculator = new PAYECalculator(grossPay);

        // when
        float result = payeCalculator.calculatePAYE(grossPay);

        // then
        float expected = 74_960;
        assertEquals(expected, result);
    }
}