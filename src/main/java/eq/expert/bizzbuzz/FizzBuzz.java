package eq.expert.bizzbuzz;

import eq.expert.bizzbuzz.exceptions.FixxBuzzParamException;

import java.util.function.IntPredicate;

import static eq.expert.bizzbuzz.types.FizzBuzzTypes.*;

public class FizzBuzz {


    public static String evaluate(final Integer value) {

        try {
            String result = EMPTY.value();

            result += module(3).test(value) ? FIZZ.value() : EMPTY.value();
            result += module(5).test(value) ? BUZZ.value() : EMPTY.value();

            return result.isEmpty() ? String.valueOf(value) : result;

        } catch (final NullPointerException e) {
            throw new FixxBuzzParamException("Input parameter is Null", e);
        }
    }

    private static IntPredicate module(final int value) {
        return i -> i % value == 0;
    }

}
