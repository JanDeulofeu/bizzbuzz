package eq.expert.bizzbuzz;

import eq.expert.bizzbuzz.exceptions.FixxBuzzParamException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource({
            "-1 , '-1'",
            "0 , 'fizzbuzz'",
            "1 , '1'       ",
            "2 , '2'       ",
            "3 , 'fizz'    ",
            "4 , '4'       ",
            "5 , 'buzz'    ",
            "6 , 'fizz'    ",
            "7 , '7'       ",
            "8 , '8'       ",
            "9 , 'fizz'    ",
            "10, 'buzz'    ",
            "15, 'fizzbuzz'",
            "30, 'fizzbuzz'",
    })
    public void validateFizzBuzzCalculationReturnsExpectedValues(final int number, final String expected) {

        assertThat(FizzBuzz.evaluate(number)).isEqualTo(expected);
    }


    @Test
    public void validateExceptionIsThrownOnNullParameter()
    {
        assertThatThrownBy(() -> FizzBuzz.evaluate(null))
                .isInstanceOf(FixxBuzzParamException.class)
                .hasMessage("Input parameter is Null");
    }
}