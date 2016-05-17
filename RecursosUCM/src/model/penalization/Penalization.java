package model.penalization;

public class Penalization {

	private int day, month, year;
	private String details, cause;

	public Penalization(int day, int month, int year, String details,
			String cause) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.details = details;
		this.cause = cause;
	}

	public int getPenalizationEndDay() {
		return this.day;
	}

	public int getPenalizationEndMonth() {
		return this.month;
	}

	public int getPenalizationEndYear() {
		return this.year;
	}

	public String getPenalizationDetails() {
		return this.details;
	}

	public String getPenalizationCause() {
		return this.cause;
	}

}
