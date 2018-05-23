package eq.expert.bizzbuzz;

import org.junit.Test;

public class BizzBuzzGeneratorTest {

    @Test
    public void validateSouT() {
        final String result = Executor.generate(1, 20);
        System.out.println(result);
    }



}