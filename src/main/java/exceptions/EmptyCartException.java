package exceptions;

/**
 * Exception thrown when a user tries to place an order with an empty cart.
 */

public class EmptyCartException extends Exception {
/**
 * Creates an exception with a custom error message.
 */
public EmptyCartException(String message) {
    super(message);
}
}
