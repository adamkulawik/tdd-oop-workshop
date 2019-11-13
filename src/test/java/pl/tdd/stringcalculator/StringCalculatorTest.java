package pl.tdd.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void returnZeroForEmptyString() {
        // when
        int result = stringCalculator.add("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void returnsInputWhenOneNumberPassed () {
        // when
        int result = stringCalculator.add("1");

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void returnSumForTwoElements () {
        // when
        int result = stringCalculator.add("1,2");

        //then
        assertThat(result).isEqualTo(3);
    }
}
