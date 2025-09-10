package ca.bcit.comp2522.bank;

/**
 * BankClient class
 * explanation goes here
 *
 * @author: Arshia
 * @version: 1.0
 */
public class BankClient
{
    final Name name;
    private final Date birthDate;
    private final Date deathDate;
    private final String clientID;
    private final Date signupDate;

    /**
     * constructor to initialize the gloabal arguments: name, birthDate, and
     * deathDate
     *
     * @params, name, birthDate, deathDate
     */
    public BankClient(final Name name, final Date birthDate,
                      final Date deathDate, final String clientID,
                      final Date signupDate)
    {
        Validation.validateBankClient(name, birthDate, deathDate, clientID, signupDate);
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.clientID = clientID;
        this.signupDate = signupDate;
    }

    /**
     * A method that returns the full name of a client and whether they are
     * alive, as well as their date of birth. If the client is dead, it
     * will return their date of death as well.
     *
     * @return details
     */
    public String getDetails()
    {
        String details = "";
        boolean isAlive;
        if (deathDate == null)
        {
            isAlive = true;
        }
        else
        {
            isAlive = false;
        }

        if (isAlive)
        {
            details += name.getFullName() + " #" + clientID + "(alive) "
                    + "joined bank on " + signupDate.getDayOfTheWeek()
                    + ", " + signupDate.getMonth() + " " + signupDate.getDay()
                    + ", " + signupDate.getYear();
        }
        else
        {
            details += name.getFullName() + " #" + clientID + "(not alive) "
                    + "joined bank on " + signupDate.getDayOfTheWeek()
                    + ", " + signupDate.getMonth() + " " + signupDate.getDay()
                    + ", " + signupDate.getYear();
        }
        return details;
    }

}
