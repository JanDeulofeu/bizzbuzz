package eq.expert.bizzbuzz.types;

public enum FizzBuzzTypes {

    FIZZ("fizz"),
    BUZZ("buzz"),
    LUCKY("lucky"),
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
