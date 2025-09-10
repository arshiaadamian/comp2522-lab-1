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
    public String getDetails() {
        boolean isAlive = (deathDate == null);

        StringBuilder details = new StringBuilder();

        details.append(name.getFullName())
                .append(" #").append(clientID)
                .append(isAlive ? " (alive)" : " (not alive)")
                .append(" was born on ").append(birthDate.getDayOfTheWeek()).append(" ")
                .append(birthDate.getMonthName()).append(" ").append(birthDate.getDay()).append(", ").append(birthDate.getYear());

        if (!isAlive) {
            details.append(" and died on ").append(deathDate.getDayOfTheWeek()).append(" ")
                    .append(deathDate.getMonthName()).append(" ").append(deathDate.getDay()).append(", ").append(deathDate.getYear());
        }

        details.append(". Joined bank on ").append(signupDate.getDayOfTheWeek()).append(" ")
                .append(signupDate.getMonthName()).append(" ").append(signupDate.getDay()).append(", ").append(signupDate.getYear());

        return details.toString();
    }

}
