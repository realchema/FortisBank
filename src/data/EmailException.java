package data;

public class EmailException extends Exception {
    private static final String message="Must be an email";
    public EmailException()
    {super(message);}
}
