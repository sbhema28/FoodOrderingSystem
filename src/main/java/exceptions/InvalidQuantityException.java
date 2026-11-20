package exceptions;
/* Raised when a customer enters an invalid quantity. */
public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) { super(message); }
}
