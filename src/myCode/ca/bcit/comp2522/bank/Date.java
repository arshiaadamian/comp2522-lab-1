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

    // Year constraints
    public static final int MIN_YEAR = 1800;
    public static final int MAX_YEAR = 2025;

    // Calendar-size constants
    public static final int MONTHS_IN_YEAR = 12;
    public static final int DAYS_IN_WEEK = 7;

    // Month indexes for special handling
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;

    // Leap year divisors
    private static final int LEAP_YEAR_DIVISOR = 4;
    private static final int CENTURY_DIVISOR = 100;
    private static final int FOUR_CENTURY_DIVISOR = 400;

    // Year-part extraction / arithmetic
    private static final int MODULUS_FOR_YEAR_PART = 100;
    private static final int MONTH_DIVISOR_FOR_TWELVES = 12;
    private static final int DIVISOR_FOR_FOURS = 4;

    // Century boundary years (for offsets below)
    private static final int YEAR_1900 = 1900;
    private static final int YEAR_2000 = 2000;

    // Century offsets used by the day-of-week computation
    private static final int OFFSET_2000_AND_AFTER = 6;
    private static final int OFFSET_BEFORE_1900 = 2;

    // Leap-year adjustment for Jan/Feb
    private static final int LEAP_YEAR_ADJUSTMENT = 1;

    // String format for YYYY-MM-DD
    private static final String DATE_FORMAT = "%04d-%02d-%02d";

    // Month/day lookup
    private static final int UNUSED_MONTH_INDEX = 0;
    public static final int[] DAYS_IN_MONTH = {
            UNUSED_MONTH_INDEX, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    // Month codes for day-of-week calculation (index aligned with month number)
    private static final int[] MONTH_CODES = {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

    // Day names for modulo result 0..6
    private static final String[] DAY_NAMES = {
            "saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"
    };

    // Month names (index 0 unused to align with month numbers 1..12)
    private static final String[] MONTH_NAMES = {
            "",
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    /**
     * Constructs a Date object with validation.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @throws IllegalArgumentException if the date is invalid
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        // validation
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
        return String.format(DATE_FORMAT, year, month, day);
    }

    /**
     * Returns the day of the week (e.g., "monday", "tuesday") based on this date.
     *
     * @return day of week as lowercase String
     */
    public String getDayOfTheWeek() {
        int centuryOffset = 0;

        if (year >= YEAR_2000) {
            centuryOffset = OFFSET_2000_AND_AFTER;
        } else if (year < YEAR_1900) {
            centuryOffset = OFFSET_BEFORE_1900;
        }

        boolean leap = isLeapYear(year);
        boolean adjustForLeap = leap && (month == JANUARY || month == FEBRUARY);

        int y = year % MODULUS_FOR_YEAR_PART;
        int numTwelves = y / MONTH_DIVISOR_FOR_TWELVES;
        int remainder = y % MONTH_DIVISOR_FOR_TWELVES;
        int numFours = remainder / DIVISOR_FOR_FOURS;

        int total = numTwelves + remainder + numFours + day + MONTH_CODES[month] + centuryOffset;

        if (adjustForLeap) {
            total -= LEAP_YEAR_ADJUSTMENT;
        }

        int dayIndex = total % DAYS_IN_WEEK;
        return DAY_NAMES[dayIndex];
    }

    /**
     * Method to return the month as a string.
     *
     * @return the month name
     */
    public String getMonthName() {
        return MONTH_NAMES[month];
    }

    /**
     * Returns if given year is leap year.
     *
     * @param y the year
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(final int y) {
        return (y % LEAP_YEAR_DIVISOR == 0 && y % CENTURY_DIVISOR != 0)
                || (y % FOUR_CENTURY_DIVISOR == 0);
    }
}
