package eq.expert.bizzbuzz.executor;

import eq.expert.bizzbuzz.exceptions.FizzBuzzParamException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExecutorTest {

    @ParameterizedTest
    @CsvSource({
            "-1 , -1, '-1'",
            "0 , 0, 'fizzbuzz'",
            "1 , 1, '1'       ",
            "2 , 2, '2'       ",
            "3 , 3, 'fizz'    ",
            "4 , 4, '4'       ",
            "5 , 5, 'buzz'    ",
            "6 , 6, 'fizz'    ",
            "7 , 7, '7'       ",
            "8 , 8, '8'       ",
            "9 , 9, 'fizz'    ",
            "10, 10, 'buzz'    ",
            "15, 15, 'fizzbuzz'",
            "30, 30, 'fizzbuzz'",
    })
    public void validateFizzBuzzCalculationReturnsExpectedValuesForRangesOfZero(final Integer from, final Integer to, final String expected) {

        assertThat(FizzBuzzExecutor.generate(from, to)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({

            "-1,     20, '-1 fizzbuzz 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz'",
            "0,      20, 'fizzbuzz 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz'",
            "0,       0, 'fizzbuzz'",
            "0,       1, 'fizzbuzz 1'",
            "1,      10, '1 2 fizz 4 buzz fizz 7 8 fizz buzz'",
            "1,      20, '1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz'",
            "20,     30, 'buzz fizz 22 23 fizz buzz 26 fizz 28 29 fizzbuzz'",
            "1000, 1001, 'buzz 1001'",
    })
    public void validateFizzBuzzCalculationReturnsExpectedValuesForDifferentRanges(final Integer from, final Integer to, final String expected) {

        assertThat(FizzBuzzExecutor.generate(from, to)).isEqualTo(expected);
    }


    @Test
    public void validateExceptionIsThrownFromValueLowerThanTo() {
        assertThatThrownBy(() -> FizzBuzzExecutor.generate(100, 10))
                .isInstanceOf(FizzBuzzParamException.class)
                .hasMessage("Input parameter From lower than To");
    }


    @Test
    public void validateExceptionIsThrownIfInputFromParamIsNull() {
        assertThatThrownBy(() -> FizzBuzzExecutor.generate(100, null))
                .isInstanceOf(FizzBuzzParamException.class)
                .hasMessage("Input parameter is Null");
    }

    @Test
    public void validateExceptionIsThrownIfInputToParamIsNull() {
        assertThatThrownBy(() -> FizzBuzzExecutor.generate(null, 1))
                .isInstanceOf(FizzBuzzParamException.class)
                .hasMessage("Input parameter is Null");
    }

    @Test
    public void validateExceptionIsThrownIfInputParamsAreNull() {
        assertThatThrownBy(() -> FizzBuzzExecutor.generate(null, null))
                .isInstanceOf(FizzBuzzParamException.class)
                .hasMessage("Input parameter is Null");
    }
}