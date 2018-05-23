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
            "-1 , -1, '-1 integer: 1'",
            "0 , 0, 'fizzbuzz fizzbuzz: 1'",
            "1 , 1, '1 integer: 1'       ",
            "2 , 2, '2 integer: 1'       ",
            "3 , 3, 'lucky lucky: 1'   ",
            "4 , 4, '4 integer: 1'       ",
            "5 , 5, 'buzz buzz: 1'    ",
            "6 , 6, 'fizz fizz: 1'    ",
            "7 , 7, '7 integer: 1'       ",
            "8 , 8, '8 integer: 1'       ",
            "9 , 9, 'fizz fizz: 1'    ",
            "10, 10, 'buzz buzz: 1'   ",
            "15, 15, 'fizzbuzz fizzbuzz: 1'",
            "30, 30, 'lucky lucky: 1'",
    })
    public void validateFizzBuzzCalculationReturnsExpectedValuesForRangesOfZero(final Integer from, final Integer to, final String expected) {

        assertThat(FizzBuzzExecutor.generate(from, to)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({

            "0,      20, 'fizzbuzz 1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz lucky: 2 integer: 10 fizz: 4 fizzbuzz: 2 buzz: 3'",
            "0,       0, 'fizzbuzz fizzbuzz: 1'",
            "0,       1, 'fizzbuzz 1 integer: 1 fizzbuzz: 1'",
            "0,       3, 'fizzbuzz 1 2 lucky lucky: 1 integer: 2 fizzbuzz: 1'",
            "3,       3, 'lucky lucky: 1'",
            "1,      10, '1 2 lucky 4 buzz fizz 7 8 fizz buzz lucky: 1 integer: 5 fizz: 2 buzz: 2'",
            "1,      20, '1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz lucky: 2 integer: 10 fizzbuzz: 1 fizz: 4 buzz: 3'",
            "20,     30, 'buzz fizz 22 lucky fizz buzz 26 fizz 28 29 lucky lucky: 2 integer: 4 fizz: 3 buzz: 2'",
            "1000, 1001, 'buzz 1001 integer: 1 buzz: 1'",
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