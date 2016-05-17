package model.material;

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
	
	public int getDay () {
		return day;
	}
	
	public int getMonth () {
		return month;
	}
	
	public int getYear () {
		return year;
	}
	
	public String horaToString(){
		if(hour > 9){
			return hour + ":00";
		} else{
			return "0" + hour + ":00";
		}
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Fecha )) {
			return false;
		} else {
			Fecha f = (Fecha) o;
			return (f.getDay() == day && f.getYear() == year && f.getHour() == hour && f.getMonth() == month);

		}
	}
	
	public int hashCode() {
		return hour * 3600 + day * 86400;
	}
	
}
