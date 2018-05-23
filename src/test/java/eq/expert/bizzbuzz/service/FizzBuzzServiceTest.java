package eq.expert.bizzbuzz.service;

import eq.expert.bizzbuzz.exceptions.FizzBuzzParamException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class FizzBuzzServiceTest {

    @ParameterizedTest
    @CsvSource({
            "-1 , '-1'",
            "0 , 'fizzbuzz'",
            "1 , '1'       ",
            "2 , '2'       ",
            "3 , 'lucky'    ",
            "4 , '4'       ",
            "5 , 'buzz'    ",
            "6 , 'fizz'    ",
            "7 , '7'       ",
            "8 , '8'       ",
            "9 , 'fizz'    ",
            "10, 'buzz'    ",
            "13, 'lucky'    ",
            "15, 'fizzbuzz'",
            "30, 'lucky'",
            "33, 'lucky'",
    })
    public void validateFizzBuzzCalculationReturnsExpectedValues(final int number, final String expected) {

        assertThat(FizzBuzzService.evaluate(number)).isEqualTo(expected);
    }


    @Test
    public void validateExceptionIsThrownOnNullParameter()
    {
        assertThatThrownBy(() -> FizzBuzzService.evaluate(null))
                .isInstanceOf(FizzBuzzParamException.class)
                .hasMessage("Input parameter is Null");
    }
}