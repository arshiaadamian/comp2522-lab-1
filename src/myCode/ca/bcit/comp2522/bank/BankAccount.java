package ca.bcit.comp2522.bank;

/**
 * BankAccount class that keeps track the balance in USD, the pin number and also the
 * openinc and closing(closing could be null) date of the account.
 *
 * @author Arshia
 * @version 1.0
 */
public class BankAccount
{
    private final BankClient client;
    private double balanceUsd;
    private final int pin;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;

    /**
     * constructor to validate all the instance variables and initialize them.
     * @param client
     * @param balanceUsd
     * @param pin
     * @param accountNumber
     * @param accountOpened
     * @param accountClosed
     */
    public BankAccount(final BankClient client, final double balanceUsd,
                       final int pin, final String accountNumber,
                       final Date accountOpened, final Date accountClosed)
    {
        // validation method to be implemented in future in the validation class.
        Validation.validateBankAccount(accountNumber);

        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
    }

    /**
     * method to withdraw USD from the amountUsd variable.
     * @param amountUsd
     */
    public void withdraw(final double amountUsd)
    {
        balanceUsd -= amountUsd;
    }

    /**
     * method to withdraw USD from the amountUsd variable if the pin variable matches
     * the pinToMatch variable.
     *
     * @param amountUsd
     * @param pinToMatch
     */
    public void withdraw(final double amountUsd, final int pinToMatch)
    {
        if (pin ==  pinToMatch)
        {
            balanceUsd -= amountUsd;
        }
        else
        {
            System.out.println("Invalid pin");
            return;
        }
    }


    /**
     * Method to get output the details of a client and also tell whether a client
     * is alive or dead, and if they still have an account open.
     * @return
     */
    public String getDetails() {
        String details = client.name.getFullName() + " had $" + balanceUsd
                + " USD in account #" + accountNumber + " which he opened on "
                + accountOpened.getDayOfTheWeek() + " " + accountOpened.getMonthName()
                + " " + accountOpened.getDay() + ", " + accountOpened.getYear();

        if (accountClosed != null) {
            details += " and closed " + accountClosed.getDayOfTheWeek() + " "
                    + accountClosed.getMonthName() + " " + accountClosed.getDay()
                    + ", " + accountClosed.getYear();
        } else {
            details += " and the account is still open.";
        }

        return details;
    }



}
