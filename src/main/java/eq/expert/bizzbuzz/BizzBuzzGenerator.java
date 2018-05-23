package eq.expert.bizzbuzz;

import eq.expert.bizzbuzz.predicates.Fizzbuzz;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class BizzBuzzGenerator implements Fizzbuzz {

//
//    public String fizzBuzz(int number) {
//        String result = EMPTY.value();
//
//        if (String.valueOf(number).contains("3")) {
//            return LUCKY.value();
//        }
//        result += module(3).test(number) ? FIZZ.value() : EMPTY.value();
//        result += module(5).test(number) ? BUZZ.value() : EMPTY.value();
//
//        return result.isEmpty() ? String.valueOf(number) : result;
//    }


    public void generate()
    {

        List<String> result = IntStream.rangeClosed(1, 20)
                .mapToObj(value -> fizzBuzz(value))
                .collect(Collectors.toList());

//                .forEach(System.out::println)
        Map<String, Long> collect = result.stream().collect(groupingBy(a -> {
            try {
                Integer.valueOf(a);
                return "integer";
            } catch (NumberFormatException e) {
                return a;
            }

        }, Collectors.counting()));

        result.forEach(System.out::println);
        collect.entrySet().forEach(a ->
                System.out.println(String.format("%s:%s", a.getKey(), a.getValue())));
    }

//    public static void main(String[] args) {
//        BizzBuzzGenerator myApproach = new BizzBuzzGenerator();
//
//        List<String> result = IntStream.rangeClosed(1, 20)
//                .mapToObj(myApproach::fizzBuzz)
//                .collect(Collectors.toList());
//
////                .forEach(System.out::println)
//        Map<String, Long> collect = result.stream().collect(groupingBy(a -> {
//            try {
//                Integer.valueOf(a);
//                return "integer";
//            } catch (NumberFormatException e) {
//                return a;
//            }
//
//        }, Collectors.counting()));
//
//        result.forEach(System.out::println);
//        collect.entrySet().forEach(a ->
//                System.out.println(String.format("%s:%s", a.getKey(), a.getValue())));
//    }

}
