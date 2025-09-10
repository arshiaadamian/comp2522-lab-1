package ca.bcit.comp2522.bank;

/**
 * Entry point to run the banking system simulation.
 * Demonstrates creation and interaction with BankClient and BankAccount.
 */
public class Main {
    public static void main(String[] args) {
        // Albert Einstein
        Name einsteinName = new Name("Albert", "Einstein");
        Date einsteinBirth = new Date(1879, 3, 14);
        Date einsteinDeath = new Date(1955, 4, 18);
        Date einsteinSignup = new Date(1900, 1, 1);
        Date einsteinClosed = new Date(1950, 10, 14);
        BankClient einsteinClient = new BankClient(einsteinName, einsteinBirth, einsteinDeath, "123456", einsteinSignup);
        BankAccount einsteinAccount = new BankAccount(einsteinClient, 1000.0, 3141, "abc123", einsteinSignup, einsteinClosed);
        einsteinAccount.withdraw(100);

        System.out.println(einsteinName.getInitials());
        System.out.println(einsteinName.getFullName());
        System.out.println(einsteinName.getReverseName());
        System.out.println(einsteinClient.getDetails());
        System.out.println(einsteinAccount.getDetails());

        System.out.println();

        // Nelson Mandela
        Name mandelaName = new Name("Nelson", "Mandela");
        Date mandelaBirth = new Date(1918, 7, 18);
        Date mandelaDeath = new Date(2013, 12, 5);
        Date mandelaSignup = new Date(1994, 5, 10);
        BankClient mandelaClient = new BankClient(mandelaName, mandelaBirth, mandelaDeath, "654321", mandelaSignup);
        BankAccount mandelaAccount = new BankAccount(mandelaClient, 2000.0, 4664, "654321", mandelaSignup, null);
        mandelaAccount.withdraw(200, 4664);

        System.out.println(mandelaName.getInitials());
        System.out.println(mandelaName.getFullName());
        System.out.println(mandelaName.getReverseName());
        System.out.println(mandelaClient.getDetails());
        System.out.println(mandelaAccount.getDetails());

        System.out.println();

        // Frida Kahlo
        Name kahloName = new Name("Frida", "Kahlo");
        Date kahloBirth = new Date(1907, 7, 6);
        Date kahloDeath = new Date(1954, 7, 13);
        Date kahloSignup = new Date(1940, 1, 1);
        Date kahloClosed = new Date(1954, 7, 13);
        BankClient kahloClient = new BankClient(kahloName, kahloBirth, kahloDeath, "frd123", kahloSignup);
        BankAccount kahloAccount = new BankAccount(kahloClient, 500.0, 1907, "frd123", kahloSignup, kahloClosed);
        kahloAccount.withdraw(50);

        System.out.println(kahloName.getInitials());
        System.out.println(kahloName.getFullName());
        System.out.println(kahloName.getReverseName());
        System.out.println(kahloClient.getDetails());
        System.out.println(kahloAccount.getDetails());

        System.out.println();

        // Jackie Chan
        Name chanName = new Name("Jackie", "Chan");
        Date chanBirth = new Date(1954, 4, 7);
        Date chanSignup = new Date(1980, 10, 1);
        BankClient chanClient = new BankClient(chanName, chanBirth, null, "chan78", chanSignup);
        BankAccount chanAccount = new BankAccount(chanClient, 3000.0, 1954, "chan789", chanSignup, null);
        chanAccount.withdraw(500, 1954);

        System.out.println(chanName.getInitials());
        System.out.println(chanName.getFullName());
        System.out.println(chanName.getReverseName());
        System.out.println(chanClient.getDetails());
        System.out.println(chanAccount.getDetails());
    }
}