package eq.expert.bizzbuzz.predicates;

import static eq.expert.bizzbuzz.types.FizzBuzzTypes.*;
import static eq.expert.bizzbuzz.types.FizzBuzzTypes.EMPTY;

public interface Fizzbuzz extends Multiple{

     default String fizzBuzz(int number) {
        String result = EMPTY.value();

        if (String.valueOf(number).contains("3")) {
            return LUCKY.value();
        }
        result += module(3).test(number) ? FIZZ.value() : EMPTY.value();
        result += module(5).test(number) ? BUZZ.value() : EMPTY.value();

        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
