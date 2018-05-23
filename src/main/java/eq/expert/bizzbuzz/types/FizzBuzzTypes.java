package eq.expert.bizzbuzz.types;


/**
 * Possible output tags to generate a FizzBuzz output.
 */
public enum FizzBuzzTypes {

    FIZZ("fizz"),
    BUZZ("buzz"),
    LUCKY("lucky"),
    INTEGER("integer"),
    EMPTY(""),
    SPACE(" ");

    private final String value;

    FizzBuzzTypes(final String value) {
        this.value = value;
    }

    public String value()
    {
        return value;
    }
}
