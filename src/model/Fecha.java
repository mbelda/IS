package model;

public class Fecha {
	private int year;
	private int month;
	private int day;
	private int hour;
	
	public Fecha(int year, int month, int day, int hour){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
	}
	
	public int getHour () {
		return hour;
	}
	
	public int getday () {
		return day;
	}
	
	public int getmonth () {
		return month;
	}
	
	public int get () {
		return year;
	}
}
