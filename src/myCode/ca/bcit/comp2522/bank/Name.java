package ca.bcit.comp2522.bank;

/**
 * class to record the name and the lastname of a bank user
 *
 * @author: Arshia
 * @version: 1.0
 */
public class Name {

    private final String first;
    private final String last;

    /**
    * public constructor that takes final strings first and last, and checks
     * if they are null or if their length exceeds 45. In those cases it will
     * throw an IllegalArgumentException error.
     *
     * @param first, last
     *
     * @throws IllegalArgumentException
     */
    public Name(final String first, final String last)
    {
        Validation.validateName(first, last);

        this.first = first;
        this.last = last;
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


    /**
     * initials getter method that returns the initials of a person's name as
     * a string.
     *
     * @return initials
     */
    public String getInitials()
    {
        final String initials;
        initials = first.substring(0, 1).toUpperCase() + "."
                + last.substring(0, 1).toUpperCase();

        return initials;
    }


    /**
     * A method that returns the full name of a person in proper format as
     * a string, meaning the first letters of the first and lastname will
     * be in capital case regardless of what the user have entered before.
     *
     * @return fullName
     */
    public String getFullName()
    {
        final String fullName;
        final String firstInProperForm;
        final String lastInProperForm;

        firstInProperForm = first.substring(0, 1).toUpperCase()
                + first.substring(1).toLowerCase();
        lastInProperForm = last.substring(0, 1).toUpperCase()
                + last.substring(1).toLowerCase();

        fullName = firstInProperForm + " " + lastInProperForm;

        return fullName;
    }


    /**
     * A method that returns the first and lastname respectively in reversed
     * order.
     *
     * @return reverseName
     */
    public String getReverseName()
    {
        final String reverseName;
        String firstReversed = "";
        String lastReversed = "";

        for (int i = 0; i < first.length(); i++)
        {
            firstReversed += first.charAt(first.length() - 1 - i);
        }

        for (int i = 0; i < last.length(); i++)
        {
            lastReversed += last.charAt(last.length() - 1 - i);
        }

        reverseName = lastReversed + " " + firstReversed;

        return reverseName;
    }

    /**
     * main function for testing purposes, printing the fullname normally and also in reverse.
     *
     */
    public static void main(final String[] args)
    {
        Name name1 = new Name("arshia", "adamian");

        System.out.println(name1.getFullName());
        System.out.println(name1.getReverseName());
    }

}
