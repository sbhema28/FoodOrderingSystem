package exceptions;

/**
 * Custom exception used when checkout is attempted with no cart items.
 */

public class EmptyCartException extends Exception {
/**
 * Creates an exception with a custom error message.
 */
public EmptyCartException(String message) {
    super(message);
}
}
