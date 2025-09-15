package ca.bcit.comp2522.bank;

/**
 * Entry point for running the banking system simulation.
 * Demonstrates the creation of BankClient and BankAccount objects,
 * as well as interactions such as deposits, withdrawals, and retrieving account details.
 *
 * This class simulates a few well-known historical figures as bank clients.
 * It showcases object instantiation, method calls, and output of details.
 *
 * @author Arshia
 * @version 1.0
 */
public class Main {

    // --- Albert Einstein constants ---
    private static final int EINSTEIN_BIRTH_YEAR = 1879;
    private static final int EINSTEIN_BIRTH_MONTH = 3;
    private static final int EINSTEIN_BIRTH_DAY = 14;
    private static final int EINSTEIN_DEATH_YEAR = 1955;
    private static final int EINSTEIN_DEATH_MONTH = 4;
    private static final int EINSTEIN_DEATH_DAY = 18;
    private static final int EINSTEIN_SIGNUP_YEAR = 1900;
    private static final int EINSTEIN_SIGNUP_MONTH = 1;
    private static final int EINSTEIN_SIGNUP_DAY = 1;
    private static final int EINSTEIN_CLOSED_YEAR = 1950;
    private static final int EINSTEIN_CLOSED_MONTH = 10;
    private static final int EINSTEIN_CLOSED_DAY = 14;
    private static final double EINSTEIN_INITIAL_BALANCE = 1000.0;
    private static final int EINSTEIN_PIN = 3141;
    private static final String EINSTEIN_ACCOUNT_NUMBER = "abc123";
    private static final double EINSTEIN_WITHDRAW_AMOUNT = 100.0;

    // --- Nelson Mandela constants ---
    private static final int MANDELA_BIRTH_YEAR = 1918;
    private static final int MANDELA_BIRTH_MONTH = 7;
    private static final int MANDELA_BIRTH_DAY = 18;
    private static final int MANDELA_DEATH_YEAR = 2013;
    private static final int MANDELA_DEATH_MONTH = 12;
    private static final int MANDELA_DEATH_DAY = 5;
    private static final int MANDELA_SIGNUP_YEAR = 1994;
    private static final int MANDELA_SIGNUP_MONTH = 5;
    private static final int MANDELA_SIGNUP_DAY = 10;
    private static final double MANDELA_INITIAL_BALANCE = 2000.0;
    private static final int MANDELA_PIN = 4664;
    private static final String MANDELA_ACCOUNT_NUMBER = "654321";
    private static final double MANDELA_WITHDRAW_AMOUNT = 200.0;

    // --- Frida Kahlo constants ---
    private static final int KAHLO_BIRTH_YEAR = 1907;
    private static final int KAHLO_BIRTH_MONTH = 7;
    private static final int KAHLO_BIRTH_DAY = 6;
    private static final int KAHLO_DEATH_YEAR = 1954;
    private static final int KAHLO_DEATH_MONTH = 7;
    private static final int KAHLO_DEATH_DAY = 13;
    private static final int KAHLO_SIGNUP_YEAR = 1940;
    private static final int KAHLO_SIGNUP_MONTH = 1;
    private static final int KAHLO_SIGNUP_DAY = 1;
    private static final int KAHLO_CLOSED_YEAR = 1954;
    private static final int KAHLO_CLOSED_MONTH = 7;
    private static final int KAHLO_CLOSED_DAY = 13;
    private static final double KAHLO_INITIAL_BALANCE = 500.0;
    private static final int KAHLO_PIN = 1907;
    private static final String KAHLO_ACCOUNT_NUMBER = "frd123";
    private static final double KAHLO_WITHDRAW_AMOUNT = 50.0;

    // --- Jackie Chan constants ---
    private static final int CHAN_BIRTH_YEAR = 1954;
    private static final int CHAN_BIRTH_MONTH = 4;
    private static final int CHAN_BIRTH_DAY = 7;
    private static final int CHAN_SIGNUP_YEAR = 1980;
    private static final int CHAN_SIGNUP_MONTH = 10;
    private static final int CHAN_SIGNUP_DAY = 1;
    private static final double CHAN_INITIAL_BALANCE = 3000.0;
    private static final int CHAN_PIN = 1954;
    private static final String CHAN_ACCOUNT_NUMBER = "chan789";
    private static final double CHAN_WITHDRAW_AMOUNT = 500.0;

    /**
     * Runs the banking simulation by creating clients, accounts,
     * performing withdrawals, and printing details.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // --- Albert Einstein ---
        Name einsteinName = new Name("Albert", "Einstein");
        Date einsteinBirth = new Date(EINSTEIN_BIRTH_YEAR, EINSTEIN_BIRTH_MONTH, EINSTEIN_BIRTH_DAY);
        Date einsteinDeath = new Date(EINSTEIN_DEATH_YEAR, EINSTEIN_DEATH_MONTH, EINSTEIN_DEATH_DAY);
        Date einsteinSignup = new Date(EINSTEIN_SIGNUP_YEAR, EINSTEIN_SIGNUP_MONTH, EINSTEIN_SIGNUP_DAY);
        Date einsteinClosed = new Date(EINSTEIN_CLOSED_YEAR, EINSTEIN_CLOSED_MONTH, EINSTEIN_CLOSED_DAY);
        BankClient einsteinClient = new BankClient(einsteinName, einsteinBirth, einsteinDeath, "123456", einsteinSignup);
        BankAccount einsteinAccount = new BankAccount(einsteinClient, EINSTEIN_INITIAL_BALANCE, EINSTEIN_PIN, EINSTEIN_ACCOUNT_NUMBER, einsteinSignup, einsteinClosed);
        einsteinAccount.withdraw(EINSTEIN_WITHDRAW_AMOUNT);

        System.out.println(einsteinName.getInitials());
        System.out.println(einsteinName.getFullName());
        System.out.println(einsteinName.getReverseName());
        System.out.println(einsteinClient.getDetails());
        System.out.println(einsteinAccount.getDetails());

        System.out.println();

        // --- Nelson Mandela ---
        Name mandelaName = new Name("Nelson", "Mandela");
        Date mandelaBirth = new Date(MANDELA_BIRTH_YEAR, MANDELA_BIRTH_MONTH, MANDELA_BIRTH_DAY);
        Date mandelaDeath = new Date(MANDELA_DEATH_YEAR, MANDELA_DEATH_MONTH, MANDELA_DEATH_DAY);
        Date mandelaSignup = new Date(MANDELA_SIGNUP_YEAR, MANDELA_SIGNUP_MONTH, MANDELA_SIGNUP_DAY);
        BankClient mandelaClient = new BankClient(mandelaName, mandelaBirth, mandelaDeath, MANDELA_ACCOUNT_NUMBER, mandelaSignup);
        BankAccount mandelaAccount = new BankAccount(mandelaClient, MANDELA_INITIAL_BALANCE, MANDELA_PIN, MANDELA_ACCOUNT_NUMBER, mandelaSignup, null);
        mandelaAccount.withdraw(MANDELA_WITHDRAW_AMOUNT, MANDELA_PIN);

        System.out.println(mandelaName.getInitials());
        System.out.println(mandelaName.getFullName());
        System.out.println(mandelaName.getReverseName());
        System.out.println(mandelaClient.getDetails());
        System.out.println(mandelaAccount.getDetails());

        System.out.println();

        // --- Frida Kahlo ---
        Name kahloName = new Name("Frida", "Kahlo");
        Date kahloBirth = new Date(KAHLO_BIRTH_YEAR, KAHLO_BIRTH_MONTH, KAHLO_BIRTH_DAY);
        Date kahloDeath = new Date(KAHLO_DEATH_YEAR, KAHLO_DEATH_MONTH, KAHLO_DEATH_DAY);
        Date kahloSignup = new Date(KAHLO_SIGNUP_YEAR, KAHLO_SIGNUP_MONTH, KAHLO_SIGNUP_DAY);
        Date kahloClosed = new Date(KAHLO_CLOSED_YEAR, KAHLO_CLOSED_MONTH, KAHLO_CLOSED_DAY);
        BankClient kahloClient = new BankClient(kahloName, kahloBirth, kahloDeath, KAHLO_ACCOUNT_NUMBER, kahloSignup);
        BankAccount kahloAccount = new BankAccount(kahloClient, KAHLO_INITIAL_BALANCE, KAHLO_PIN, KAHLO_ACCOUNT_NUMBER, kahloSignup, kahloClosed);
        kahloAccount.withdraw(KAHLO_WITHDRAW_AMOUNT);

        System.out.println(kahloName.getInitials());
        System.out.println(kahloName.getFullName());
        System.out.println(kahloName.getReverseName());
        System.out.println(kahloClient.getDetails());
        System.out.println(kahloAccount.getDetails());

        System.out.println();

        // --- Jackie Chan ---
        Name chanName = new Name("Jackie", "Chan");
        Date chanBirth = new Date(CHAN_BIRTH_YEAR, CHAN_BIRTH_MONTH, CHAN_BIRTH_DAY);
        Date chanSignup = new Date(CHAN_SIGNUP_YEAR, CHAN_SIGNUP_MONTH, CHAN_SIGNUP_DAY);
        BankClient chanClient = new BankClient(chanName, chanBirth, null, "chan78", chanSignup);
        BankAccount chanAccount = new BankAccount(chanClient, CHAN_INITIAL_BALANCE, CHAN_PIN, CHAN_ACCOUNT_NUMBER, chanSignup, null);
        chanAccount.withdraw(CHAN_WITHDRAW_AMOUNT, CHAN_PIN);

        System.out.println(chanName.getInitials());
        System.out.println(chanName.getFullName());
        System.out.println(chanName.getReverseName());
        System.out.println(chanClient.getDetails());
        System.out.println(chanAccount.getDetails());
    }
}
