package ca.bcit.comp2522.bank;

/**
 * BankClient class
 * explanation goes here
 *
 * @author: Arshia, Indy
 * @version: 1.0
 */
public class BankClient
{
    private final Name name;
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
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.clientID = clientID;
        this.signupDate = signupDaet;
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
        if (deathDate != null)
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
