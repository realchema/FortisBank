package data;

public class Validation {
    public static boolean OnlyNum(long num) throws OnlyNumbers
    {
        if (!(Long.toString(num).matches("[0-9]+")))
        {
            throw new OnlyNumbers();
        }
        return true;
    }
    public static boolean IsOnlyAlphabets(String in) throws OnlyAlphabets
    {
        if (!(in.matches("^([a-zA-Z]+(.)?[\\s]*)$")))
        {
            throw new OnlyAlphabets();

        }
        return true;
    }

    public static boolean IsOnlyEmail(String em) throws EmailException
    {
        if (!(em.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")))
        {
            throw new EmailException();
        }
        return true;
    }
    public static boolean IsOnlySSN(String ssn) throws SSNException
    {
        if (!(ssn.matches(
                "^\\d{3}-\\d{2}-\\d{4}$")))
        {
            throw new SSNException();
        }
        return true;
    }

    public static boolean OnlyPhone(String p) throws PhoneException
    {
        if (!(p.matches(
                "^[2-9]\\d{2}-\\d{3}-\\d{4}$")))
        {
            throw new PhoneException();
        }
        return true;
    }
    public static boolean PostCode(String po) throws PostalCodeException
    {
        if (!(po.matches("^[a-zA-Z]{1}[0-9]{1}[a-zA-Z]{1}(\\-||){1}[0-9]{1}[a-zA-Z]{1}[0-9]{1}$")))
        {
            throw new PostalCodeException();
        }
        return true;
    }
}
