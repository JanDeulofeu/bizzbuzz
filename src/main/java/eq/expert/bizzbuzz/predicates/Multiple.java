package eq.expert.bizzbuzz.predicates;

import java.util.function.IntPredicate;

public interface Multiple {

     default IntPredicate module(int value) {
        return i -> i % value == 0;
    }

}
