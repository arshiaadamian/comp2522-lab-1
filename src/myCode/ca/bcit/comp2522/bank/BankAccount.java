package ca.bcit.comp2522.bank;

/**
 * Represents a bank account that keeps track of the account balance in USD,
 * the account PIN, and the opening and closing dates (closing may be null).
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
     * Constructs a new BankAccount, validating and initializing all instance variables.
     *
     * @param client         the client who owns the account
     * @param balanceUsd     the initial account balance in USD
     * @param pin            the account PIN
     * @param accountNumber  the account number
     * @param accountOpened  the date the account was opened
     * @param accountClosed  the date the account was closed (may be null)
     */
    public BankAccount(final BankClient client,
                       final double balanceUsd,
                       final int pin,
                       final String accountNumber,
                       final Date accountOpened,
                       final Date accountClosed)
    {
        // Validation logic to be implemented in the Validation class.
        Validation.validateBankAccount(accountNumber);

        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
    }

    /**
     * Withdraws the specified amount in USD from the account balance.
     *
     * @param amountUsd the amount to withdraw
     */
    public void withdraw(final double amountUsd)
    {
        balanceUsd -= amountUsd;
    }

    /**
     * Withdraws the specified amount in USD from the account balance
     * if the provided PIN matches the account PIN.
     *
     * @param amountUsd   the amount to withdraw
     * @param pinToMatch  the PIN provided for verification
     */
    public void withdraw(final double amountUsd, final int pinToMatch)
    {
        if (pin == pinToMatch)
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
     * Returns a string containing details of the client, including account
     * balance, account number, opening date, and whether the account is still open
     * or has been closed.
     *
     * @return a string containing account and client details
     */
    public String getDetails() {
        String details = client.name.getFullName() + " had $" + balanceUsd
                + " USD in account #" + accountNumber + " which was opened on "
                + accountOpened.getDayOfTheWeek() + " " + accountOpened.getMonthName()
                + " " + accountOpened.getDay() + ", " + accountOpened.getYear();

        if (accountClosed != null) {
            details += " and closed on " + accountClosed.getDayOfTheWeek() + " "
                    + accountClosed.getMonthName() + " " + accountClosed.getDay()
                    + ", " + accountClosed.getYear();
        } else {
            details += " and the account is still open.";
        }

        return details;
    }
}
