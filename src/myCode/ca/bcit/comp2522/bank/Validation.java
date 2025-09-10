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
}
