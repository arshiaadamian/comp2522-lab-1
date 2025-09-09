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
    private static final int MIN_YEAR = 1800;
    private static final int MAX_YEAR = 2025;
    private static final int[] DAYS_IN_MONTH = {
            0, 31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31
    };

    // Day of week constants
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;
}

/**
 * Constructs a Date object with validation.
 * @param year
 * @param month
 * @param day
 * @throws IllegalArgumentException if the date is invalid
 */
public Date(final int year, final int month, final int day) {
    if (year < MIN_YEAR || year > MAX_YEAR) {
        throw new IllegalArgumentException("Invalid year. Pick a year between 1800 and 2025");
    }

    if (month < 1 || month > 12) {
        throw new IllegalArgumentException("Invalid month. Pick a month between 1 and 12");
    }

    int maxDays = DAYS_IN_MONTH[month];
    if (month == 2 && isLeapYear(year)) {
        maxDays = 29;
    }

    if (day < 1 || day > maxDays) {
        throw new IllegalArgumentException("Invalid day. Pick a day between 1 and 31");
    }

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
 * Returns if given year is leap year.
 *
 * @param y the year
 * @return true if leap year, false otherwise
 */
public boolean isLeapYear(final int y) {
    return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
}