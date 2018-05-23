package eq.expert.bizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static eq.expert.bizzbuzz.types.FizzBuzzTypes.*;

public class Executor {


    public static String generate(final Integer from, final Integer to) {

        return IntStream.rangeClosed(from, to)
                .mapToObj(value -> FizzBuzz.evaluate(value))
                .collect(Collectors.joining(SPACE.value()));

    }
}
