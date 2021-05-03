import java.util.Scanner;
/**
 * This program calculates the day of the week from a date.
 *
 * @author  Marlon Poddalgoda
 * @version 1.0
 * @since 2021-05-01
 */

public final class DayOfTheWeek {
    private DayOfTheWeek() {

        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }

    /**
    * This method calculates the day of the week.
    * @param yearInt This value is the year.
    * @param monthInt This value is the month.
    * @param dayInt This value is the day.
    * @return weekName This value is the day of the week.
    */
    public static String theDayOfTheWeek(final int yearInt, final int monthInt,
                                          final int dayInt) {
        // variables
        double weekDay = 0;
        int weekDayInt = 0;
        int century = 0;
        int yearInteger = 0;
        int year = 0;
        String weekName = "";

        // constants
        final int january = 11;
        final int february = 12;
        final int two = 2;
        final int four = 4;
        final int weekLength = 7;
        final int sunday = 0;
        final int monday = 1;
        final int tuesday = 2;
        final int wednesday = 3;
        final int thursday = 4;
        final int friday = 5;
        final int saturday = 6;

        // these constants are for the repetitive pattern of 30-day months
        final double monthPattern1 = 2.6;
        final double monthPattern2 = 0.2;

        // if month is january or february, subtract 1 from year
        if (monthInt == january || monthInt == february) {
            // subtracting 1
            yearInteger = yearInt - 1;
        } else {
            // Does nothing to other months
            yearInteger = yearInt + 0;
        }

        // first 2 digits of the year
        century = Integer.parseInt(Integer.toString(yearInt).substring(0, two));

        // last 2 digits of the year
        year = Integer.parseInt(Integer.toString(yearInt).substring(two, four));

        // algorithm for day of the week
        weekDay = (dayInt + (monthPattern1 * monthInt - monthPattern2) - two
                   * century + year + (year / four) + (century / four))
                   % weekLength;

        // if statement for negative output
        if (weekDay < 0) {
            // adds seven to negative answer
            weekDay += weekLength;
        } else {
            weekDay = weekDay;
        }

        // converts double to int
        weekDayInt = (int) weekDay;

        // assign weekday numbers to names
        switch (weekDayInt) {
            case sunday:
                weekName = "Sunday";
                break;
            case monday:
                weekName = "Monday";
                break;
            case tuesday:
                weekName = "Tuesday";
                break;
            case wednesday:
                weekName = "Wednesday";
                break;
            case thursday:
                weekName = "Thursday";
                break;
            case friday:
                weekName = "Friday";
                break;
            case saturday:
                weekName = "Saturday";
                break;
            default:
                System.out.println(weekDayInt);
        }

        // return output
        return (weekName);
    }

    /**
    * This method takes in user input and passes to the method.
    * @param args
    */
    public static void main(final String[] args) {

        // Create new Scanner-type variable
        Scanner yearInput = new Scanner(System.in);
        Scanner monthInput = new Scanner(System.in);
        Scanner dayInput = new Scanner(System.in);

        // Variables
        int yearInt;
        int monthInt;
        int dayInt;
        String dayOfWeek = "";

        // constants
        final int minYear = 1000;
        final int maxYear = 9999;
        final int minMonth = 1;
        final int maxMonth = 12;
        final int minDay = 1;
        final int maxDay = 31;
        // constants used to set month values
        final int march = 3;
        final int two = 2;
        final int ten = 10;

        // program information
        System.out.println("This program calculates the day of the "
            + "week from an inputted date.");
        System.out.println();

        // Asks user to enter a year
        System.out.print("Enter a year: ");

        while (true) {
            // check if input is an integer
            while (!yearInput.hasNextInt()) {
                System.out.println("That's not a year!");
                System.out.print("Enter a year: ");
                yearInput.next(); // moves scanner until correct value
            }
            yearInt = yearInput.nextInt();

            // check if input is positive
            if (yearInt <= 0) {
                System.out.println("Please enter a positive number.");
                System.out.print("Enter a year: ");
                continue;
            } else if (yearInt >= minYear && yearInt <= maxYear) {
                // check if year is within valid date range
                break;
            } else {
                // error catch
                System.out.println("That's too low/high. Try again!");
                System.out.print("Enter a year: ");
                continue;
            }
        }

        // Asks user to input a month
        System.out.print("Enter a month (01-12): ");

        while (true) {
            // check if input is an integer
            while (!monthInput.hasNextInt()) {
                System.out.println("That's not a month, try again.");
                System.out.print("Enter a month (01-12): ");
                monthInput.next(); // moves scanner until correct value
            }
            monthInt = monthInput.nextInt();

            // check if input is positive
            if (monthInt <= 0) {
                System.out.println("Please enter a positive number.");
                System.out.print("Enter a month (01-12): ");
                continue;
            } else if (monthInt >= minMonth && monthInt <= maxMonth) {
                // check if month is within valid date range

                // January and February are set as part of the previous year
                // Set all months to new values
                if (monthInt >= march) {
                    // set 1 == march, 2 == April... 10 == December
                    monthInt -= two;
                } else if (monthInt < march) {
                    // set 11 == January, 12 == February
                    monthInt += ten;
                } else {
                    monthInt = monthInt;
                }
                break;
            } else {
                // error catch
                System.out.println("That's not a month, try again.");
                System.out.print("Enter a month (01-12): ");
                continue;
            }
        }

        // Asks user to input a day
        System.out.print("Enter a day (01-31): ");

        while (true) {
            // check if input is an integer
            while (!dayInput.hasNextInt()) {
                System.out.println("That's not a day, try again.");
                System.out.print("Enter a day (01-31): ");
                dayInput.next(); // moves scanner until correct value
            }
            dayInt = dayInput.nextInt();

            // check if input is positive
            if (dayInt <= 0) {
                System.out.println("Please enter a positive number.");
                System.out.print("Enter a day (01-31): ");
                continue;
            } else if (dayInt >= minDay && dayInt <= maxDay) {
                // check if day is within valid date range
                break;
            } else {
                // error catch
                System.out.println("That's not a day, try again.");
                System.out.print("Enter a day (01-31): ");
                continue;
            }
        }

        // call procedure
        dayOfWeek = theDayOfTheWeek(yearInt, monthInt, dayInt);

        // output day of the week
        System.out.println("");
        System.out.println("This date is on a " + dayOfWeek + ".");

        System.out.println("");
        System.out.println("Done.");
    }
}
