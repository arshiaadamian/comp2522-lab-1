package ca.bcit.comp2522.bank;

/**
 * Validation class: Every validation in every constructor is written here
 * using public static void methods, then they will be called inside
 * the corresponding constructors of different classes.
 *
 * @author Arshia, Indy
 * @version 1.0
 */
public class Validation
{
    public static void validateBankClient(final Name name, final Date birthDate,
                                   final Date deathDate, final String clientID,
                                   final Date signupDaet)
    {
        if (name == null || birthDate == null || clientID == null
                || signupDaet == null)
        {
            throw new IllegalArgumentException("Name, birthDate, clientID " +
                    "or signupDate cannot be null.");
        }

        if (clientID.length() > 7 || clientID.length() < 6)
        {
            throw new IllegalArgumentException("clientID must be between 6 and 7.");
        }
    }


    /**
     * method to validate the name in the Name class, it checks whether a name is null, blank, and also
     * checks the length of the name and whether the name contains the word "admin", if so it will
     * throw an error.
     *
     * @param first
     * @param last
     */
    public static void validateName(final String first, final String last)
    {
        if (first == null || last == null)
        {
            throw new IllegalArgumentException("first or last null");
        }
        if (first.length() < 1 || last.length() < 1)
        {
            throw new IllegalArgumentException("first or last empty");
        }
        if (first.length() > 45 || last.length() > 45)
        {
            throw new IllegalArgumentException("first or last length exceed 45");
        }
        if (first.contains("admin") || last.contains("admin"))
        {
            throw new IllegalArgumentException("first or last can not contain admin");
        }
    }


    /**
     * method to validate the bank account and is to be used inside the BankAccount class's
     * constructor. It checks if the account number is greater or less than 6, if so
     * it will return an error.
     *
     * @param accountNumber
     */
    public static void validateBankAccount(final String accountNumber)
    {
        if (accountNumber == null || accountNumber.length() > 7 || accountNumber.length() < 6)
        {
            throw new IllegalArgumentException("accountNumber must be between 6 and 7.");
        }
    }


    /**
     * method to validate a Date object, it is to be used inside the Date class's constructor.
     * It checks whether the year is between 1800 and 2025, and also whether
     * the month is a valid number. It also checks if the day is less than or greater than
     * the maxDays, and if any of those situations occur, it will throw an error.
     * @param year
     * @param month
     * @param day
     */
    public static void validateDate(final int year, final int month, final int day)
    {
        if (year < Date.MIN_YEAR || year > Date.MAX_YEAR) {
            throw new IllegalArgumentException("Invalid year. Pick a year between 1800 and 2025");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month. Pick a month between 1 and 12");
        }

        int maxDays = Date.DAYS_IN_MONTH[month];
        if (month == 2 && Date.isLeapYear(year)) {
            maxDays = 29;
        }

        if (day < 1 || day > maxDays) {
            throw new IllegalArgumentException("Invalid day. Pick a day between 1 and 31");
        }
    }
}
