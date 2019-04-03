package data;

public class PostalCodeException extends Exception {
    private static final String message="Must be a zip code";
    public PostalCodeException()
    {super(message);}
}
