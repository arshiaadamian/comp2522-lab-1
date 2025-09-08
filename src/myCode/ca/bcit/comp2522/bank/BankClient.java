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
    private final String name;
    private final Date birthDate;
    private final Date deathDate;

    /**
     * constructor to initialize the gloabal arguments: name, birthDate, and
     * deathDate
     *
     * @params, name, birthDate, deathDate
     */
    public BankClient(final String name, final Date birthDate, final Date deathDate)
    {
        if (name == null || birthDate == null)
        {
            throw new IllegalArgumentException("Name and birthDate cannot be null.");
        }
        if (name.length() < 1)
        {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
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

        return details;
    }

}
