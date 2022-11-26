package lib.exceptions;

public class UseFailureException extends Exception {
    public UseFailureException() {
        super();
    }

    public UseFailureException(String message) {
        super(message);
    }

    public UseFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
