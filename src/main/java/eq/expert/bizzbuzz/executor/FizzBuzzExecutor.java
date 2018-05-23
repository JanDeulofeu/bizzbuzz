package eq.expert.bizzbuzz.executor;

import eq.expert.bizzbuzz.exceptions.FizzBuzzParamException;
import eq.expert.bizzbuzz.service.FizzBuzzService;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static eq.expert.bizzbuzz.types.FizzBuzzTypes.SPACE;

/**
 * Generation of a concatenated output String with bizzbuzz possibles outputs for a given numeric inout range.
 */
public class FizzBuzzExecutor {


    public static String generate(final Integer from, final Integer to) {

        validateInputParameters(from, to);

        return IntStream.rangeClosed(from, to)
                .mapToObj(FizzBuzzService::evaluate)
                .collect(Collectors.joining(SPACE.value()));
    }

    /**
     * Validate order input parameters and nullability.
     *
     * @param from
     * @param to
     */
    private static void validateInputParameters(final Integer from, final Integer to) {
        if (to == null || from == null) {
            throw new FizzBuzzParamException("Input parameter is Null");
        } else if (to < from) {
            throw new FizzBuzzParamException("Input parameter From lower than To");
        }
    }
}
