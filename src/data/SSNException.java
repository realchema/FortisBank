package data;

public class SSNException extends Exception {
    private static final String message = "Must be Social Security Number";

    public SSNException() {
        super(message);
    }
}
