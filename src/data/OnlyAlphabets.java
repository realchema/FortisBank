package data;

public class OnlyAlphabets extends Exception {
    private static final String message="It must be alphabets only";
    public OnlyAlphabets()
    {super(message);}
}
