package ca.bcit.comp2522.bank;

/**
 * class to record the name and the lastname of a bank user
 *
 * @author: Arshia, Indy
 * @version: 1.0
 */
public class Name {

    private final String first;
    private final String last;

    /**
    * public constructor that takes final strings first and last, and checks
     * if they are null or if their length exceeds 45. In those cases it will
     * throw an IllegalArgumentException error.
     */
    public Name(final String first, final String last)
    {
        if (first == null || last == null)
        {
            throw new IllegalArgumentException("first or last null");
        }
        if (first.length() > 45 || last.length() > 45)
        {
            throw new IllegalArgumentException("first or last length exceed 45");
        }
    }

    /**
     * first getter method that returns string first.
     *
     * @return first
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * last getter method that returns string last.
     *
     * @return last
     */
    public String getLast()
    {
        return last;
    }

    public String getInitials()
    {
        String initials;
        initials = first.substring(0, 1).toUpperCase() + "."
                + last.substring(0, 1).toUpperCase();

        return initials;
    }

}
