package task5;

public class Date {
	// Attributes
	private int year;
	private int month;
	private int day;

	/**
	 * Constructor including day,month and year
	 * 
	 * @param year
	 *            The year
	 * 
	 * @param month
	 *            The month
	 * 
	 * @param day
	 *            The day
	 * 
	 */
	public Date(int day, int month, int year) {

		if (year < 1 || month < 1 || month > 12 || day < 1) {
			System.out.println("Invalid input");
		}
		if (day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			System.out.println("This month has only 31 day's");
		} else if (day > 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			System.out.println(" This month has only 30 day's");

		} else if (month == 2 && day > 28) {
			System.out.println("This month has only 28 day's");
		}

		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Constructor including day and month
	 * 
	 * @param month
	 *            The month
	 * 
	 * @param day
	 *            The day
	 * 
	 */

	public Date(int day, int month) {
		this(day, month, 1);
	}

	/**
	 * Constructor including the day only The other attributes are set to 1
	 * 
	 * @param day
	 *            The day
	 * 
	 */
	public Date(int day) {

		this(day, 1, 1);
	}

	/**
	 * Setter for the year
	 * 
	 * @param The
	 *            year
	 */
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}
	}

	/**
	 * Setter for the month
	 * 
	 * @param The
	 *            month
	 */
	public void setMonth(int month) {
		if (month > 0 && month <= 12) {
			this.month = month;
		}
	}

	/**
	 * Setter for the day
	 * 
	 * @param The
	 *            day
	 */
	public void setDay(int day) {

		if (year < 1 || month < 1 || month > 12 || day < 1) {
			System.out.println("Invalid input");
		}
		if (day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			System.out.println("This month has 31 day's");
		} else if (day > 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			System.out.println("This month has 30 day's");

		} else if (month == 2 && day > 28) {
			System.out.println("This month has 28 day's");
		}

		this.day = day;

	}

	public void dayPassed() {

		if (day == 31 && month == 12) {
			day = 1;
			month = 1;
			year++;
		} else if (day == 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			day = 1;
			month++;

		} else if (day == 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			day = 1;
			month++;
		} else if (month == 2 && day == 28) {
			day = 1;
			month++;

		} else {
			day++;
		}

	}

	/**
	 * Method for adding one month
	 */
	public void monthPassed() {

		this.month += 1;
		if (month > 12) {
			this.month = 1;
			this.year += 1;
		}
	}

	//toString method
	@Override
	public String toString() {

		if (day > 31 || day < 0 || month > 12 || month < 0) {
			System.out.println("Invalid input");
		} else if (day < 10 && month < 10) {
			return "The date is: 0" + day + ".0" + month + "." + year;
		} else if (day < 10) {
			return "The date is: 0" + day + "." + month + "." + year;
		} else if (month < 10) {
			return "The date is: " + day + ".0" + month + "." + year;

		} else
			return "The date is: " + day + "." + month + "." + year;

		return "Please set new date ";

	}
}
