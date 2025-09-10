package ca.bcit.comp2522.bank;

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


    public static void validateBankAccount(final String accountNumber)
    {
        if (accountNumber == null || accountNumber.length() > 7 || accountNumber.length() < 6)
        {
            throw new IllegalArgumentException("accountNumber must be between 6 and 7.");
        }
    }
}
