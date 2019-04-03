package data;

public class PhoneException extends Exception{
    private static final String message="Must be a phone number";
    public PhoneException()
    {super(message);}
}

