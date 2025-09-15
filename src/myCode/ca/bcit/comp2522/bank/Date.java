package ca.bcit.comp2522.bank;

/**
 * Represents a Date with year, month, and day.
 *
 * @author Indy
 * @version 1.0
 */
public class Date {
    // Instance variables
    private final int year;
    private final int month;
    private final int day;

    // Constants
    public static final int MIN_YEAR = 1800;
    public static final int MAX_YEAR = 2025;
    public static final int[] DAYS_IN_MONTH = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    // Day of week constants
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;


    /**
     * Constructs a Date object with validation.
     *
     * @param year
     * @param month
     * @param day
     * @throws IllegalArgumentException if the date is invalid
     */
    public Date(final int year, final int month, final int day) {
        //validation
        Validation.validateDate(year, month, day);

        // Save values after validation
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the year of this date.
     *
     * @return the year as an int
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month of this date.
     *
     * @return the month as an int
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day of the month for this date.
     *
     * @return the day as an int
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the date in YYYY-MM-DD format.
     *
     * @return the date as a String
     */
    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Returns the day of the week (e.g., "monday", "tuesday") based on this date.
     *
     * @return day of week as lowercase String
     */
    public String getDayOfTheWeek() {
        final int[] MONTH_CODES = {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
        final String[] DAYS = {"saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"};

        int centuryOffset = 0;

        if (year >= 2000) {
            centuryOffset = 6;
        } else if (year < 1900) {
            centuryOffset = 2;
        }

        boolean leap = isLeapYear(year);
        boolean adjustForLeap = leap && (month == 1 || month == 2);

        int y = year % 100;
        int numTwelves = y / 12;
        int remainder = y % 12;
        int numFours = remainder / 4;

        int total = numTwelves + remainder + numFours + day + MONTH_CODES[month] + centuryOffset;

        if (adjustForLeap) {
            total -= 1;
        }

        int dayIndex = total % 7;
        return DAYS[dayIndex];
    }

    /**
     * Method to return the month as a string.
     *
     * @return
     */
    public String getMonthName() {
        String[] MONTH_NAMES = {
                "", // index 0 unused to align with month numbers
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return MONTH_NAMES[month];
    }

    /**
     * Returns if given year is leap year.
     *
     * @param y the year
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(final int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}