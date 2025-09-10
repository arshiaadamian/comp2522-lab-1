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

    public void withdraw(final double amountUsd)
    {
        balanceUsd -= amountUsd;
    }

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
