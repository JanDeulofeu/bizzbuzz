package eq.expert.bizzbuzz.exceptions;

/**
 * FizzBuzzException to manage exceptions associated with input params
 */
public class FizzBuzzParamException extends RuntimeException {

    public FizzBuzzParamException(final String message) {
        super(message);
    }

    public FizzBuzzParamException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
