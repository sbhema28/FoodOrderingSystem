package exceptions;

/**
 * Thrown when checkout is attempted with an empty cart.
 */
public class EmptyCartException extends Exception {

    public EmptyCartException(String message) {
        super(message);
    }
}
