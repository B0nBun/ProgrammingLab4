package lib.exceptions;

public class OverlookExplosionException extends RuntimeException {
    public OverlookExplosionException() {
        super("The Overlook somehow exploded");
    }
    
    public OverlookExplosionException(String message) {
        super(message);
    }
}
