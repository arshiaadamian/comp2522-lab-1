package ca.bcit.comp2522.bank;

/**
 * Represents the first and last name of a bank user.
 * Provides various methods to access and format the name.
 *
 * @author Arshia
 * @version 1.0
 */
public class Name {

    private final String first;
    private final String last;

    /**
     * Constructs a Name object with the given first and last names.
     * Validates both names using the Validation class.
     *
     * @param first the user's first name
     * @param last the user's last name
     * @throws IllegalArgumentException if either name is null,
     *         empty, too long, or contains disallowed words
     */
    public Name(final String first, final String last) {
        Validation.validateName(first, last);

        this.first = first;
        this.last = last;
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLast() {
        return last;
    }

    /**
     * Returns the initials of the user in the format "F.L".
     *
     * @return the user's initials
     */
    public String getInitials() {
        return first.substring(0, 1).toUpperCase() + "."
                + last.substring(0, 1).toUpperCase();
    }

    /**
     * Returns the full name in proper format (capitalized).
     * For example, "arshia adamian" → "Arshia Adamian".
     *
     * @return the properly formatted full name
     */
    public String getFullName() {
        final String firstInProperForm = first.substring(0, 1).toUpperCase()
                + first.substring(1).toLowerCase();
        final String lastInProperForm = last.substring(0, 1).toUpperCase()
                + last.substring(1).toLowerCase();

        return firstInProperForm + " " + lastInProperForm;
    }

    /**
     * Returns the full name with first and last names reversed.
     * Characters are reversed individually (e.g., "John" → "nhoJ").
     *
     * @return the reversed full name
     */
    public String getReverseName() {
        StringBuilder firstReversed = new StringBuilder();
        StringBuilder lastReversed = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            firstReversed.append(first.charAt(first.length() - 1 - i));
        }

        for (int i = 0; i < last.length(); i++) {
            lastReversed.append(last.charAt(last.length() - 1 - i));
        }

        return lastReversed + " " + firstReversed;
    }

    /**
     * Main method for testing purposes.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        Name name1 = new Name("arshia", "adamian");

        System.out.println(name1.getFullName());
        System.out.println(name1.getReverseName());
    }
}