package eq.expert.bizzbuzz.executor;

import eq.expert.bizzbuzz.exceptions.FizzBuzzParamException;
import eq.expert.bizzbuzz.service.FizzBuzzService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static eq.expert.bizzbuzz.types.FizzBuzzTypes.*;
import static java.util.stream.Collectors.groupingBy;

/**
 * Generation of a concatenated output String with bizzbuzz possibles outputs for a given numeric input range.
 */
public class FizzBuzzExecutor {


    public static String generate(final Integer from, final Integer to) {

        validateInputParameters(from, to);

        final List<String> bizzbuzzList = generateFizzBuzzValues(from, to);

        final String report = getReportFromGivenListOfResults(bizzbuzzList);

        return bizzbuzzList.stream().collect(Collectors.joining(SPACE.value())).concat(SPACE.value()).concat(report);
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


    /**
     * Generate a report counting the number of bizzbuzz elemets on a given response.
     * @param bizzbuzzList
     * @return bizzbuzz elemts counter
     */
    private static String getReportFromGivenListOfResults(final List<String> bizzbuzzList) {
        return bizzbuzzList.stream().collect(groupingBy(FizzBuzzExecutor::apply, Collectors.counting()))
                .entrySet().stream()
                .map(k -> String.format("%s: %s", k.getKey(), k.getValue()))
                .collect(Collectors.joining(SPACE.value()));
    }


    /**
     * Generate a bizzbuzz list of values for a given numeric input range.
     * @param from
     * @param to
     * @return bizzbuzz values
     */
    private static List<String> generateFizzBuzzValues(final Integer from, final Integer to) {
        return IntStream.rangeClosed(from, to)
                .mapToObj(FizzBuzzService::evaluate)
                .collect(Collectors.toList());
    }

    /**
     * Returns any FizzBuzz Tag if exists or a Integer if dose not exists.
     *
     * @param input
     * @return FizzBuzzTypes value
     */
    private static String apply(final String input) {
        return (input.contains(FIZZ.value()) || input.contains(BUZZ.value()) || input.contains(LUCKY.value())) ? input : INTEGER.value();
    }
}
