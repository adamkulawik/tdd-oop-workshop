package pl.tdd.stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource({"'', 0", "1, 1"} ) // six numbers
    public void paramsTest (String input, int expected) {
        assertThat(stringCalculator.add(input)).isEqualTo(expected);
    }

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
