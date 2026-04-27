package exceptions;

public class MaxFailsExceededException extends Exception {
    public MaxFailsExceededException(String message) {
        super(message);
    }
}
