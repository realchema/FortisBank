package data;

public class OnlyNumbers extends Exception {
    private static final String message="It must be digits only";
    public OnlyNumbers()
    {super(message);}
}
